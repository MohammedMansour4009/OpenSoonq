package com.assignment.opensooq.features.subcategories.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.core.base.BaseAdapter
import com.assignment.opensooq.databinding.RowSubcategoryBinding
import com.assignment.opensooq.features.categories.domain.model.category.SubCategoryLocalResponse

class SubCategoryAdapter(
    private val subCategoryList: MutableList<SubCategoryLocalResponse>,
    private val onClick: (SubCategoryLocalResponse) -> Unit
) : BaseAdapter<SubCategoryLocalResponse,SubCategoryAdapter.SubCategoryViewHolder>(subCategoryList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        return SubCategoryViewHolder(RowSubcategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.bind(subCategoryList[position])
    }

    override fun getItemCount(): Int {
        return subCategoryList.size
    }

    inner class SubCategoryViewHolder(private val binding: RowSubcategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: SubCategoryLocalResponse) {
            binding.model = model
            itemView.setOnClickListener { onClick(model) }
        }
    }
}