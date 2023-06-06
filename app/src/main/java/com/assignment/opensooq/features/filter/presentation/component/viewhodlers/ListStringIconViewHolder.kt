package com.assignment.opensooq.features.filter.presentation.component.viewhodlers

import androidx.fragment.app.FragmentManager
import com.assignment.opensooq.databinding.RowListStringIconBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse
import com.assignment.opensooq.features.filter.presentation.component.adapter.ListStringIconAdapter
import com.assignment.opensooq.features.filter.presentation.component.dialog.OptionsDialogFragment

class ListStringIconViewHolder(
    private val binding: RowListStringIconBinding,
    private val fragmentManager: FragmentManager
) : BaseFilterViewHolder(binding.root) {

    lateinit var topicFilterModel: TopicFilterModel

    override fun bind(topicFilterModel: TopicFilterModel) {
        this.topicFilterModel = topicFilterModel
        binding.recyclerView.adapter = ListStringIconAdapter(topicFilterModel.optionList, ::onClick)
        binding.model = topicFilterModel
        handleListSelected()
        initListener()
    }

    fun initListener() {
        binding.imageViewArrow.setOnClickListener {
            OptionsDialogFragment(topicFilterModel).show(fragmentManager, "option_dialog")
        }
    }

    private fun onClick(model: OptionLocalResponse) {
        model.selected = !model.selected
        handleListSelected()
    }


    private fun handleListSelected() {
        val itemsSelected = topicFilterModel.optionList.filter { it.selected }

        binding.textViewItemSelected.text = itemsSelected.joinToString(", ") { it.name }
        if (itemsSelected.isNotEmpty()) {
            binding.selected = true
            binding.textViewItemSelected.text = itemsSelected.joinToString(", ") { it.name }

        } else {
            binding.selected = false
            binding.textViewItemSelected.text = topicFilterModel.name
        }

    }

}
