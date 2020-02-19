package ch.itomy.githubtest.data.network

import ch.itomy.githubtest.data.storage.TokenStorage
import javax.inject.Inject

class GitHubTokenManager @Inject constructor(
    private val tokenStorage: TokenStorage
) : TokenManager {

    override var token: String?
        get() = tokenStorage.token
        set(value) {
            tokenStorage.token = value
        }
}