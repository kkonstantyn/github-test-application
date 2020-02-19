package ch.itomy.githubtest.common.extensions

import android.view.View

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}