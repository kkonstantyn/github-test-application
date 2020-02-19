package ch.itomy.githubtest.data.storage

import android.content.SharedPreferences
import androidx.core.content.edit

private const val KEY_TOKEN = "KEY_TOKEN"

class DefaultTokenStorage(
    private val sharedPreferences: SharedPreferences
) : TokenStorage {

    override var token: String?
        get() = sharedPreferences.getString(KEY_TOKEN, null)
        set(value) {
            sharedPreferences.edit { putString(KEY_TOKEN, value) }
        }
}