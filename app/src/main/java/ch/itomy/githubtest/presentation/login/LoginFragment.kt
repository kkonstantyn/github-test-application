package ch.itomy.githubtest.presentation.login

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.*
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import ch.itomy.githubtest.BuildConfig
import ch.itomy.githubtest.R
import ch.itomy.githubtest.common.BaseFragment
import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.common.extensions.toGone
import ch.itomy.githubtest.common.extensions.toVisible
import ch.itomy.githubtest.common.extensions.toast
import ch.itomy.githubtest.databinding.LoginFragmentBinding
import ch.itomy.githubtest.presentation.main.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    companion object {

        fun newInstance() = LoginFragment()

        private const val GITHUB_OAUTH_URL =
            "https://github.com/login/oauth/authorize?response_type=token&client_id=${BuildConfig.CLIENT_ID}"

        private const val QUERY_PARAM_CODE = "code"
        private const val REDIRECT_URL_SCHEME = "github-test"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    override val layoutId = R.layout.login_fragment

    @FlowPreview
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.authResult.observe(this) {
            when (it) {
                is Result.Progress -> onProgress()
                is Result.Success -> onUserAuthorized()
                is Result.Error -> onError(it.exception.message)
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun setupViews() {
        super.setupViews()
        clearCookies()

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.progressBar.toVisible()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.toGone()
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (request?.url?.scheme == REDIRECT_URL_SCHEME) {
                    binding.webView.toGone()
                    viewModel.auth(request.url?.getQueryParameter(QUERY_PARAM_CODE).orEmpty())
                }

                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        binding.webView.settings.apply {
            setAppCacheEnabled(false)
            cacheMode = WebSettings.LOAD_NO_CACHE
            javaScriptEnabled = true
        }

        startWebAuth()
    }

    private fun clearCookies(onComplete: () -> Unit = {}) {
        CookieManager.getInstance().removeAllCookies { onComplete() }
    }

    private fun onProgress() {
        binding.webView.toGone()
        binding.progressBar.toVisible()
    }

    private fun startWebAuth() {
        binding.webView.loadUrl(GITHUB_OAUTH_URL)
    }

    private fun onUserAuthorized() {
        MainActivity.launch(requireContext())
        requireActivity().finish()
    }

    private fun onError(message: String?) {
        requireActivity().toast(
            if (!message.isNullOrBlank()) message
            else getString(R.string.error_message)
        )

        clearCookies {
            startWebAuth()
            binding.webView.toVisible()
        }
    }
}