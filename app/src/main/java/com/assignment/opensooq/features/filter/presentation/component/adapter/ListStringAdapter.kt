package com.assignment.opensooq.features.filter.presentation.component.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.databinding.RowListStringItemBinding
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse

class ListStringAdapter(
    private val optionLocalResponses: List<OptionLocalResponse>,
    private val onClick: (OptionLocalResponse) -> Unit
) : RecyclerView.Adapter<ListStringAdapter.ListStringViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStringViewHolder {
        return ListStringViewHolder(
            RowListStringItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListStringViewHolder, position: Int) {
        val model = optionLocalResponses[position]
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return optionLocalResponses.size
    }

    inner class ListStringViewHolder(private val binding: RowListStringItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: OptionLocalResponse, position: Int) {
            binding.model = model
            itemView.setOnClickListener {
                onClick(model)
                notifyItemChanged(position)
            }
        }
    }

}