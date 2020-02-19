package ch.itomy.githubtest.di.module.data

import ch.itomy.githubtest.data.network.GitHubServiceManager
import ch.itomy.githubtest.data.network.ServiceManager
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        ServiceModule::class,
        TokenManagerModule::class
    ]
)
abstract class NetworkModule {
    @Binds
    abstract fun bindServiceManager(serviceManager: GitHubServiceManager): ServiceManager
}