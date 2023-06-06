package com.assignment.opensooq.core.view

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    load(url)
}

@BindingAdapter("checkVisibility")
fun ImageView.nullableUrl(url: String?) {
    if (url.isNullOrEmpty())
        this.visibility = View.GONE
}