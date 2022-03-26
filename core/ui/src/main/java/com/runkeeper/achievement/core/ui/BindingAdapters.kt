package com.runkeeper.achievement.core.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageUrl")
fun setImageUrl(view: ImageView, url: String) {
    Glide
        .with(view.context)
        .load(url)
        .into(view)
}

