package ch.itomy.githubtest.data.network.service

import ch.itomy.githubtest.BuildConfig
import ch.itomy.githubtest.data.model.Token
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

private const val QUERY_CODE = "code"
private const val QUERY_CLIENT_ID = "client_id"
private const val QUERY_CLIENT_SECRET = "client_secret"

private const val HEADER_ACCEPT_KEY = "Accept"
private const val HEADER_ACCEPT_VALUE = "application/json"
private const val HEADER_ACCEPT = "$HEADER_ACCEPT_KEY: $HEADER_ACCEPT_VALUE"

interface AuthService {

    @Headers(HEADER_ACCEPT)
    @POST("login/oauth/access_token")
    fun auth(
        @Query(QUERY_CODE) code: String,
        @Query(QUERY_CLIENT_ID) clientId: String = BuildConfig.CLIENT_ID,
        @Query(QUERY_CLIENT_SECRET) clientSecret: String = BuildConfig.CLIENT_SECRET
    ): Call<Token>
}