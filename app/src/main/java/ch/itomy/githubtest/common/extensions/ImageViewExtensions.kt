package ch.itomy.githubtest.common.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import ch.itomy.githubtest.R
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl", "placeholder")
fun ImageView.setImageUrl(imageUrl: String?, placeholder: Drawable?) {
    Glide.with(this)
        .load(imageUrl)
        .placeholder(placeholder)
        .into(this)
}