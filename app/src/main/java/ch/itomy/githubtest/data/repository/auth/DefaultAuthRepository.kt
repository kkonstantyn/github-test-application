package ch.itomy.githubtest.data.repository.auth

import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.data.source.auth.local.AuthLocalDataSource
import ch.itomy.githubtest.data.source.auth.remote.AuthRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DefaultAuthRepository @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {

    override fun isUserAuthorized(): Flow<Boolean> =
        flow { emit(!authLocalDataSource.token.isNullOrEmpty()) }

    override fun auth(code: String): Flow<Result<Unit>> {
        return authRemoteDataSource.auth(code).map {
            if (it is Result.Success) {
                authLocalDataSource.token = it.data
            }
            it.map { Unit }
        }
    }
}