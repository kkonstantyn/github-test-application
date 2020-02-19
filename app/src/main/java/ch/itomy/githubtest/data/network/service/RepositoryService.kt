package ch.itomy.githubtest.data.network.service

import retrofit2.http.GET
import retrofit2.http.Path

private const val SERVICE_NAME = "repos"

private const val PATH_OWNER = "owner"
private const val PATH_REPOSITORY = "repo"

interface RepositoryService {

    @GET("$SERVICE_NAME/{$PATH_OWNER}/{$PATH_REPOSITORY}/subscribers")
    fun getWatchers(@Path(PATH_OWNER) owner: String, @Path(
        PATH_REPOSITORY
    ) repository: String)
}