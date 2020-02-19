package ch.itomy.githubtest.di.module.data.source.auth

import ch.itomy.githubtest.data.source.auth.local.AuthLocalDataSource
import ch.itomy.githubtest.data.source.auth.local.DefaultAuthLocalDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AuthLocalDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindLocalDataSource(localDataSource: DefaultAuthLocalDataSource): AuthLocalDataSource
}