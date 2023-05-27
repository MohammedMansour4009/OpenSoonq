package com.assignment.opensooq.features.filter.presentation.component.viewhodlers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel

abstract class BaseFilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(topicFilterModel: TopicFilterModel)
}
