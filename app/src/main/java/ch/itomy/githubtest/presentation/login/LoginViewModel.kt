package ch.itomy.githubtest.presentation.login

import androidx.lifecycle.*
import ch.itomy.githubtest.domain.AuthUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.sample
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {
    private val authCode = MutableLiveData<String>()

    @FlowPreview
    @ExperimentalCoroutinesApi
    val authResult = authCode.asFlow()
        .sample(1_000L)
        .onEach { it.trim() }
        .flatMapLatest { authUseCase.invoke(it) }
        .asLiveData(Dispatchers.IO)

    fun auth(code: String) = authCode.postValue(code)
}