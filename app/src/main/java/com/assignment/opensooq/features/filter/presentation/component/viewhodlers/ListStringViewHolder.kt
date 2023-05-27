package com.assignment.opensooq.features.filter.presentation.component.viewhodlers

import androidx.fragment.app.FragmentManager
import com.assignment.opensooq.databinding.RowListStringBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse
import com.assignment.opensooq.features.filter.presentation.component.adapter.ListStringAdapter
import com.assignment.opensooq.features.filter.presentation.component.dialog.OptionsDialogFragment

class ListStringViewHolder(
    private val binding: RowListStringBinding,
    private val fragmentManager: FragmentManager
) : BaseFilterViewHolder(binding.root) {

    lateinit var component: TopicFilterModel

    override fun bind(topicFilterModel: TopicFilterModel) {
        this.component = topicFilterModel

        val adapter = ListStringAdapter(topicFilterModel.optionList, ::onClick)
        binding.recyclerViewListString.adapter = adapter
        binding.model = topicFilterModel
        handleListSelected()
        initListener()
    }

    fun initListener() {
        binding.imageViewArrow.setOnClickListener {
            OptionsDialogFragment(component).show(fragmentManager, "option_dialog")
        }
    }

    private fun onClick(model: OptionLocalResponse) {
        model.selected = !model.selected
        handleListSelected()
    }

    private fun handleListSelected() {
        val itemsSelected = component.optionList.filter { it.selected }

        binding.textViewItemSelected.text = itemsSelected.joinToString(", ") { it.name }
        if (itemsSelected.isNotEmpty()) {
            binding.selected = true
            binding.textViewItemSelected.text = itemsSelected.joinToString(", ") { it.name }

        } else {
            binding.selected = false
            binding.textViewItemSelected.text = component.name
        }

    }

}
