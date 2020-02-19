package ch.itomy.githubtest.data.source

import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.data.network.service.SearchService
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DefaultRepositoryRemoteDataSource @Inject constructor(
    private val searchService: SearchService
) : RepositoryRemoteDataSource {

    override fun getRepositories(query: String) = flow {
        emit(Result.Progress)
        try {
            emit(searchService.search(query).run {
                val response = execute()
                if (response.isSuccessful) Result.Success(response.body()?.items)
                else Result.Error(IOException("Connection error!"))
            })
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}