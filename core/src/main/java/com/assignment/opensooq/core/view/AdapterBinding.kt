package com.assignment.opensooq.core.view

import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    load(url)
}

@BindingAdapter("checkVisibility")
fun ImageView.nullableUrl(url: String?) {
    this.isVisible = !url.isNullOrEmpty()
}