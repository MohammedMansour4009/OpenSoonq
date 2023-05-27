package com.assignment.opensooq.features.filter.presentation.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.databinding.RowListStringIconItemBinding
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse

class ListStringIconAdapter(
    private val OptionLocalResponses: List<OptionLocalResponse>,
    private val onClick: (OptionLocalResponse) -> Unit
) : RecyclerView.Adapter<ListStringIconAdapter.ListStringIconViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStringIconViewHolder {
        return ListStringIconViewHolder(
            RowListStringIconItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListStringIconViewHolder, position: Int) {
        val model = OptionLocalResponses[position]
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return OptionLocalResponses.size
    }

    inner class ListStringIconViewHolder(private val binding: RowListStringIconItemBinding) :
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