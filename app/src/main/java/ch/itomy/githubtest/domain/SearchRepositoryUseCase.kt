package ch.itomy.githubtest.domain

import ch.itomy.githubtest.data.repository.Repository
import javax.inject.Inject

class SearchRepositoryUseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(query: String) = repository.getRepositories(query)
}