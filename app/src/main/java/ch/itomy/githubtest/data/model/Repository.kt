package ch.itomy.githubtest.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val id: Long,
    val name: String,
    val description: String,
    val owner: Owner,
    val forks: Long,
    val watchers: Long
) : Parcelable