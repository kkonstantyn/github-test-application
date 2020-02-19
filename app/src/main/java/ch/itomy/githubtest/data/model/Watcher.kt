package ch.itomy.githubtest.data.model

import com.google.gson.annotations.SerializedName

data class Watcher(
    val id: Long,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String?
)