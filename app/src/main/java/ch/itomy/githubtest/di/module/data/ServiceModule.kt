package ch.itomy.githubtest.di.module.data

import ch.itomy.githubtest.data.network.service.AuthService
import ch.itomy.githubtest.data.network.service.RepositoryService
import ch.itomy.githubtest.data.network.service.SearchService
import ch.itomy.githubtest.di.module.common.AuthorizationQualifier
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [RetrofitModule::class])
class ServiceModule {

    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Provides
    fun provideSearchService(@AuthorizationQualifier retrofit: Retrofit): SearchService =
        retrofit.create(SearchService::class.java)

    @Provides
    fun provideRepositoryService(@AuthorizationQualifier retrofit: Retrofit): RepositoryService =
        retrofit.create(RepositoryService::class.java)
}