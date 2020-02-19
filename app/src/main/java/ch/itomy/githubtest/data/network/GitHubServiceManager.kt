package ch.itomy.githubtest.data.network

import ch.itomy.githubtest.data.network.service.AuthService
import ch.itomy.githubtest.data.network.service.SearchService
import javax.inject.Inject

class GitHubServiceManager @Inject constructor(
    override val authService: AuthService,
    override val searchService: SearchService
) : ServiceManager