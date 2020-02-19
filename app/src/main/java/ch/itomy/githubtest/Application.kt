package ch.itomy.githubtest

import ch.itomy.githubtest.di.DaggerApplicationComponent
import dagger.android.DaggerApplication

class Application : DaggerApplication() {

    override fun applicationInjector() = DaggerApplicationComponent.factory().create(this)
}