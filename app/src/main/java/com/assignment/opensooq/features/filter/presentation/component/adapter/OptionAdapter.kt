package com.assignment.opensooq.features.filter.presentation.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.databinding.RowOptionBinding
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse

class OptionAdapter(
    private val optionLocalResponses: List<OptionLocalResponse>
) : RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

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
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return optionLocalResponses.size
    }

    inner class OptionViewHolder(private val binding: RowOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: OptionLocalResponse, position: Int) {
            binding.model = model
            itemView.setOnClickListener {
                notifyItemChanged(position)
            }
        }
    }

}