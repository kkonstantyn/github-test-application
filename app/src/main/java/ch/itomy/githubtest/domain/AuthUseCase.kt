package ch.itomy.githubtest.domain

import ch.itomy.githubtest.data.repository.auth.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    fun invoke(code: String) = repository.auth(code)
}