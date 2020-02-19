package ch.itomy.githubtest.data.repository

import ch.itomy.githubtest.data.source.RepositoryRemoteDataSource
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    private val repositoryRemoteDataSource: RepositoryRemoteDataSource
) : Repository {

    override fun getRepositories(query: String) =
        repositoryRemoteDataSource.getRepositories(query)
}