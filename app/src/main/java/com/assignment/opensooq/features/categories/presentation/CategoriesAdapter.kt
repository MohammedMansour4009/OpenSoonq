package com.assignment.opensooq.features.categories.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.core.base.BaseAdapter
import com.assignment.opensooq.databinding.RowCategoryBinding
import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse

class CategoriesAdapter(
    private val categories: List<CategoryModelLocalResponse>,
    private val onClick: (CategoryModelLocalResponse) -> Unit
) : BaseAdapter<CategoryModelLocalResponse, CategoriesAdapter.CategoriesViewHolder>(ArrayList(categories)) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder(RowCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val model = categories[position]
        holder.bind(model)
    }


    inner class CategoriesViewHolder(private val binding: RowCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: CategoryModelLocalResponse) {
            binding.model = model
            itemView.setOnClickListener { onClick(model) }
        }
    }
}