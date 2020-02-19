package ch.itomy.githubtest.di.module.presentation

import androidx.lifecycle.ViewModel
import ch.itomy.githubtest.di.module.common.ViewModelKey
import ch.itomy.githubtest.di.module.common.ViewModelModule
import ch.itomy.githubtest.presentation.login.LoginFragment
import ch.itomy.githubtest.presentation.login.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class LoginActivityModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class
        ]
    )
    abstract fun contributeFragment(): LoginFragment

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindViewModel(viewModel: LoginViewModel): ViewModel
}