package ch.itomy.githubtest.di.module.data.source.auth

import ch.itomy.githubtest.data.source.auth.remote.AuthRemoteDataSource
import ch.itomy.githubtest.data.source.auth.remote.DefaultAuthRemoteDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AuthRemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindDataSource(dataSource: DefaultAuthRemoteDataSource): AuthRemoteDataSource
}