package ch.itomy.githubtest.di.module.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import ch.itomy.githubtest.data.storage.DefaultTokenStorage
import ch.itomy.githubtest.data.storage.TokenStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val PREF_NAME = "GitHubPrefs"

@Module
class StorageModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideStorage(sharedPreferences: SharedPreferences): TokenStorage =
        DefaultTokenStorage(sharedPreferences)
}