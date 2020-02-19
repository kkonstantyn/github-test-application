package ch.itomy.githubtest.data.repository.auth

import ch.itomy.githubtest.common.Result
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun isUserAuthorized(): Flow<Boolean>

    fun auth(code: String): Flow<Result<Unit>>
}