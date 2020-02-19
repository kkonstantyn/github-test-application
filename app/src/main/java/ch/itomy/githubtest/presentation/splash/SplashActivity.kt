package ch.itomy.githubtest.presentation.splash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import ch.itomy.githubtest.presentation.login.LoginActivity
import ch.itomy.githubtest.presentation.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.coroutines.*
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SplashViewModel by viewModels { viewModelFactory }

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.isUserAuthorized.observe(this) { onUserAuthorized(it) }
    }

    private fun onUserAuthorized(isAuthorized: Boolean) {
        if (isAuthorized) startMain()
        else startLogin()
    }

    private fun startLogin() {
        LoginActivity.launch(this)
        finish()
    }

    private fun startMain() {
        MainActivity.launch(this)
        finish()
    }
}