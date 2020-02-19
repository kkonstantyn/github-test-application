package ch.itomy.githubtest.data.source

import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.data.model.Repository
import kotlinx.coroutines.flow.Flow

interface RepositoryRemoteDataSource {
    fun getRepositories(query: String): Flow<Result<List<Repository>?>>
}