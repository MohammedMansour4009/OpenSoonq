package com.assignment.opensooq.features.filter.presentation.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.core.base.BaseAdapter
import com.assignment.opensooq.databinding.RowOptionBinding
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse

class OptionAdapter(
    private val optionLocalResponses: MutableList<OptionLocalResponse>
) : BaseAdapter<OptionLocalResponse, OptionAdapter.OptionViewHolder>(optionLocalResponses) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        return OptionViewHolder(
            RowOptionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val model = optionLocalResponses[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return optionLocalResponses.size
    }

    fun resetOptions() {
        optionLocalResponses.forEachIndexed { index, optionLocalResponse ->
            if (optionLocalResponse.selected) {
                optionLocalResponse.selected = false
                notifyItemChanged(index)
            }
        }
    }

    fun getOptions(): List<OptionLocalResponse> {
        return optionLocalResponses
    }

    inner class OptionViewHolder(private val binding: RowOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: OptionLocalResponse) {
            binding.model = model
            binding.checkbox.setOnClickListener {
                model.selected = (it as CheckBox).isChecked
            }
        }
    }

}