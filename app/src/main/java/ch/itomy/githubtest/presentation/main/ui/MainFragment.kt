package ch.itomy.githubtest.presentation.main.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import ch.itomy.githubtest.R
import ch.itomy.githubtest.common.BaseFragment
import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.common.extensions.toGone
import ch.itomy.githubtest.common.extensions.toVisible
import ch.itomy.githubtest.common.extensions.toast
import ch.itomy.githubtest.data.model.Repository
import ch.itomy.githubtest.databinding.MainFragmentBinding
import ch.itomy.githubtest.presentation.details.DetailsActivity
import ch.itomy.githubtest.presentation.main.adapter.RepositoryAdapter
import ch.itomy.githubtest.presentation.main.viewmodel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

class MainFragment : BaseFragment<MainFragmentBinding>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private val adapter by lazy { RepositoryAdapter { onRepositoryClick(it) } }

    override val layoutId = R.layout.main_fragment

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel

        viewModel.searchResult.observe(this) {
            binding.progressBar.toGone()
            when (it) {
                is Result.Progress -> binding.progressBar.toVisible()
                is Result.Success -> adapter.submitList(it.data)
                is Result.Error -> showError(it.exception.message)
            }
        }
    }

    override fun setupViews() {
        binding.repositoriesRecyclerView.adapter = adapter
    }

    private fun onRepositoryClick(repository: Repository) {
        DetailsActivity.launch(requireContext(), repository)
    }

    private fun showError(message: String?) {
        requireContext().toast(message ?: getString(R.string.error_message))
    }
}