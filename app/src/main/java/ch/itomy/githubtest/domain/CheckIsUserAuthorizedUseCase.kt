package ch.itomy.githubtest.domain

import ch.itomy.githubtest.data.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckIsUserAuthorizedUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    fun invoke(): Flow<Boolean> = repository.isUserAuthorized()
}