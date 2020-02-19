package ch.itomy.githubtest.di.module.data

import ch.itomy.githubtest.data.network.GitHubTokenManager
import ch.itomy.githubtest.data.network.TokenManager
import dagger.Binds
import dagger.Module

@Module
abstract class TokenManagerModule {
    @Binds
    abstract fun bindTokenManager(tokenManager: GitHubTokenManager): TokenManager
}