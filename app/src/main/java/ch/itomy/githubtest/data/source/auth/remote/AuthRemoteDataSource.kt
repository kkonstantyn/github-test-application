package ch.itomy.githubtest.data.source.auth.remote

import ch.itomy.githubtest.common.Result
import kotlinx.coroutines.flow.Flow

interface AuthRemoteDataSource {
    fun auth(code: String): Flow<Result<String>>
}