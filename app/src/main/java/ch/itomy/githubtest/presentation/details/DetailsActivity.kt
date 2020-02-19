package ch.itomy.githubtest.presentation.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.itomy.githubtest.R
import ch.itomy.githubtest.data.model.Repository
import ch.itomy.githubtest.presentation.details.ui.DetailsFragment

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance())
                .commitNow()
        }
    }

    companion object {

        fun launch(context: Context, repository: Repository) {
            context.startActivity(Intent(context, DetailsActivity::class.java).apply {
                this.repository = repository
            })
        }

        private const val KEY_REPOSITORY = "KEY_REPOSITORY"

        private var Intent.repository: Repository?
            get() = getParcelableExtra(KEY_REPOSITORY)
            set(value) {
                putExtra(KEY_REPOSITORY, value)
            }
    }
}
