package ch.itomy.githubtest.di.module.data

import ch.itomy.githubtest.common.interceptor.AuthorizationHeaderInterceptor
import ch.itomy.githubtest.data.storage.TokenStorage
import ch.itomy.githubtest.di.module.common.AuthorizationQualifier
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val AUTH_BASE_URL = "https://github.com"
private const val API_BASE_URL = "https://api.github.com/"

@Module(includes = [TokenManagerModule::class])
class RetrofitModule {

    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(AUTH_BASE_URL)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    @AuthorizationQualifier
    fun provideAuthRetrofit(
        @AuthorizationQualifier client: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(API_BASE_URL)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @AuthorizationQualifier
    fun provideAuthOkHttpClient(
        interceptor: Interceptor,
        @AuthorizationQualifier authInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(authInterceptor)
        .build()

    @Provides
    fun provideGsonConverter(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    fun provideHttpLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @AuthorizationQualifier
    fun provideAuthInterceptor(tokenStorage: TokenStorage): Interceptor =
        AuthorizationHeaderInterceptor(tokenStorage)
}