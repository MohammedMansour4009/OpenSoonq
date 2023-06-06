package com.assignment.opensooq.features.filter.presentation.component.dialog.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.core.base.BaseAdapter
import com.assignment.opensooq.databinding.RowNumericOptionBinding
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse


class NumericOptionAdapter(
    private val optionLocalResponses: MutableList<OptionLocalResponse>,
    private val onClickListener: (OptionLocalResponse) -> Unit
) : BaseAdapter<OptionLocalResponse, NumericOptionAdapter.NumericViewHolder>(optionLocalResponses) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumericViewHolder {
        return NumericViewHolder(
            RowNumericOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumericViewHolder, position: Int) {
        val model = optionLocalResponses[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return optionLocalResponses.size
    }

    inner class NumericViewHolder(private val binding: RowNumericOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: OptionLocalResponse) {
            binding.model = model
            itemView.setOnClickListener {
                onClickListener(model)
            }
        }
    }

}