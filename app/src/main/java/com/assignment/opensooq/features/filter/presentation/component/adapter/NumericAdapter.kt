package com.assignment.opensooq.features.filter.presentation.component.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.opensooq.databinding.RowNumericOptionBinding
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse

class NumericAdapter(
    private val optionLocalResponses: List<OptionLocalResponse>
) : RecyclerView.Adapter<NumericAdapter.NumericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumericViewHolder {
        return NumericViewHolder(
            RowNumericOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NumericViewHolder, position: Int) {
        val model = optionLocalResponses[position]
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return optionLocalResponses.size
    }

    inner class NumericViewHolder(private val binding: RowNumericOptionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: OptionLocalResponse, position: Int) {
            binding.model = model
            itemView.setOnClickListener {
                notifyItemChanged(position)
            }
        }
    }

}