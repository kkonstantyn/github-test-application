package ch.itomy.githubtest.data.network.service

import ch.itomy.githubtest.data.model.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val SERVICE_NAME = "search"

interface SearchService {

    @GET("$SERVICE_NAME/repositories")
    fun search(@Query("q") query: String?): Call<Repositories>
}