package ch.itomy.githubtest.data.source.auth.local

import ch.itomy.githubtest.data.storage.TokenStorage
import javax.inject.Inject

class DefaultAuthLocalDataSource @Inject constructor(
    private val tokenStorage: TokenStorage
) : AuthLocalDataSource {

    override var token = tokenStorage.token
}