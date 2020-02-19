package ch.itomy.githubtest.data.repository

import ch.itomy.githubtest.common.Result
import ch.itomy.githubtest.data.model.Repository
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getRepositories(query: String): Flow<Result<List<Repository>?>>
}