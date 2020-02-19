package ch.itomy.githubtest.di.module.data.repository

import ch.itomy.githubtest.data.repository.auth.AuthRepository
import ch.itomy.githubtest.data.repository.auth.DefaultAuthRepository
import ch.itomy.githubtest.di.module.data.source.auth.AuthLocalDataSourceModule
import ch.itomy.githubtest.di.module.data.source.auth.AuthRemoteDataSourceModule
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        AuthLocalDataSourceModule::class,
        AuthRemoteDataSourceModule::class
    ]
)
abstract class AuthRepositoryModule {
    @Binds
    abstract fun bindRepository(repository: DefaultAuthRepository): AuthRepository
}