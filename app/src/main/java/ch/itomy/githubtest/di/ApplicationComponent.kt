package ch.itomy.githubtest.di

import android.content.Context
import ch.itomy.githubtest.Application
import ch.itomy.githubtest.di.module.ApplicationModule
import ch.itomy.githubtest.di.module.presentation.LoginActivityModule
import ch.itomy.githubtest.di.module.presentation.MainActivityModule
import ch.itomy.githubtest.di.module.presentation.SplashActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        SplashActivityModule::class,
        LoginActivityModule::class,
        MainActivityModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}