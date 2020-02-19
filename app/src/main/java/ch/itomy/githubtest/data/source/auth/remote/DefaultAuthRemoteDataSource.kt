package ch.itomy.githubtest.data.source.auth.remote

import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.data.network.service.AuthService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DefaultAuthRemoteDataSource @Inject constructor(
    private val authService: AuthService
) : AuthRemoteDataSource {

    override fun auth(code: String): Flow<Result<String>> {
        return flow {
            emit(Result.Progress)
            try {
                emit(authService.auth(code).run {
                    val response = execute()
                    val token = response.body()?.accessToken
                    if (response.isSuccessful && token != null) Result.Success(token)
                    else Result.Error(IOException("Connection error!"))
                })
            } catch (e: Exception) {
                emit(Result.Error(e))
            }
        }
    }

}