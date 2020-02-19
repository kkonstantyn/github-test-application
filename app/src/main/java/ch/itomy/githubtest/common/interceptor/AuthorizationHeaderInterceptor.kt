package ch.itomy.githubtest.common.interceptor

import ch.itomy.githubtest.data.storage.TokenStorage
import okhttp3.Interceptor
import javax.inject.Inject

private const val AUTH_HEADER = "Authorization"

class AuthorizationHeaderInterceptor @Inject constructor(
    private val tokenStorage: TokenStorage
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain) = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader(AUTH_HEADER, tokenStorage.token ?: "")
                .build()
        )
    }
}