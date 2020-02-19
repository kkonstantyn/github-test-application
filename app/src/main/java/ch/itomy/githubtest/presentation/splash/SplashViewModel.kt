package ch.itomy.githubtest.presentation.splash

import androidx.lifecycle.*
import ch.itomy.githubtest.domain.CheckIsUserAuthorizedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.flow.take
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    checkIsUserAuthorizedUseCase: CheckIsUserAuthorizedUseCase
) : ViewModel() {

    @FlowPreview
    @ExperimentalCoroutinesApi
    val isUserAuthorized = checkIsUserAuthorizedUseCase.invoke()
        .take(1)
        .asLiveData(Dispatchers.IO)
}