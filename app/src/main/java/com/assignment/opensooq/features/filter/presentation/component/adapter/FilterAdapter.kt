package com.assignment.opensooq.features.filter.presentation.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.ComponentAdapterType
import com.assignment.opensooq.features.filter.presentation.component.viewhodlers.BaseFilterViewHolder

class FilterAdapter(
    private val currentList: List<TopicFilterModel>,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<BaseFilterViewHolder>() {

    private val types by lazy { ComponentAdapterType.values() }

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var context: Context

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        layoutInflater = LayoutInflater.from(recyclerView.context)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseFilterViewHolder {
        val type = types[viewType]
        return type.factory.create(layoutInflater, parent, currentList,fragmentManager)
    }

    override fun onBindViewHolder(holder: BaseFilterViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return ComponentAdapterType.valueOf(currentList[position].componentType.name).ordinal
    }

    fun getSpanCount(position: Int): Int {
        return ComponentAdapterType.valueOf(currentList[position].componentType.name).spanCount
    }
}