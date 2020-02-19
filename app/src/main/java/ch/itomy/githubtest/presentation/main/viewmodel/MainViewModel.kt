package ch.itomy.githubtest.presentation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import ch.itomy.githubtest.domain.SearchRepositoryUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.sample
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val searchRepositoryUseCase: SearchRepositoryUseCase
) : ViewModel() {
    val searchQuery = MutableLiveData<String>()

    @FlowPreview
    @ExperimentalCoroutinesApi
    val searchResult = searchQuery.asFlow()
        .sample(1_000L)
        .onEach { it.trim() }
        .flatMapLatest { searchRepositoryUseCase.invoke(it) }
        .asLiveData(IO)
}