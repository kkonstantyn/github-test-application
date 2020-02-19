package ch.itomy.githubtest.di.module

import ch.itomy.githubtest.data.repository.DefaultRepository
import ch.itomy.githubtest.data.repository.Repository
import ch.itomy.githubtest.data.source.DefaultRepositoryRemoteDataSource
import ch.itomy.githubtest.data.source.RepositoryRemoteDataSource
import ch.itomy.githubtest.di.module.data.NetworkModule
import ch.itomy.githubtest.di.module.data.StorageModule
import ch.itomy.githubtest.di.module.data.repository.AuthRepositoryModule
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(
    includes = [
        StorageModule::class,
        NetworkModule::class,
        AuthRepositoryModule::class
    ]
)
abstract class ApplicationModule {
    @Binds
    @Singleton
    abstract fun provideRepository(repository: DefaultRepository): Repository

    @Binds
    @Singleton
    abstract fun provideRemoteDataSource(remoteDataSource: DefaultRepositoryRemoteDataSource): RepositoryRemoteDataSource
}