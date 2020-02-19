package ch.itomy.githubtest.di.module.presentation

import androidx.lifecycle.ViewModel
import ch.itomy.githubtest.di.module.common.ViewModelKey
import ch.itomy.githubtest.di.module.common.ViewModelModule
import ch.itomy.githubtest.presentation.splash.SplashActivity
import ch.itomy.githubtest.presentation.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class SplashActivityModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class
        ]
    )
    abstract fun contributeActivity(): SplashActivity

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindViewModel(viewModel: SplashViewModel): ViewModel
}