package ch.itomy.githubtest.data.network

import ch.itomy.githubtest.data.network.service.AuthService
import ch.itomy.githubtest.data.network.service.SearchService

interface ServiceManager {
    val authService: AuthService
    val searchService: SearchService
}