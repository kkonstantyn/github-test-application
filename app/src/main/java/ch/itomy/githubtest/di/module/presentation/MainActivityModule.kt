package ch.itomy.githubtest.di.module.presentation

import androidx.lifecycle.ViewModel
import ch.itomy.githubtest.di.module.common.ViewModelKey
import ch.itomy.githubtest.di.module.common.ViewModelModule
import ch.itomy.githubtest.presentation.main.MainActivity
import ch.itomy.githubtest.presentation.main.ui.MainFragment
import ch.itomy.githubtest.presentation.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class
        ]
    )
    abstract fun bindActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class
        ]
    )
    abstract fun bindFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel
}