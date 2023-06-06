package com.assignment.opensooq.features.filter.presentation.component.viewhodlers

import androidx.fragment.app.FragmentManager
import com.assignment.opensooq.databinding.RowListNumericBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.dialog.NumericOptionsDialogFragment

class NumericViewHolder(
    private val binding: RowListNumericBinding,
    private val fragmentManager: FragmentManager
) : BaseFilterViewHolder(binding.root) {

    lateinit var topicFilterModel: TopicFilterModel

    override fun bind(topicFilterModel: TopicFilterModel) {
        this.topicFilterModel = topicFilterModel
        binding.model = topicFilterModel
        initListener()
        handleView()
    }

    private fun handleView() {
        topicFilterModel.optionList.firstOrNull { it.selected }?.numericOptionValue?.let {
            binding.numericOptionValue = topicFilterModel.optionList.first { it.selected }.numericOptionValue
        }
    }

    private fun initListener() {
        binding.textViewFrom.setOnClickListener {
            showNumericOptionsDialog(topicFilterModel)
        }
        binding.textViewTo.setOnClickListener {
            showNumericOptionsDialog(topicFilterModel, false)
        }

    }

    private fun showNumericOptionsDialog(component: TopicFilterModel, isFrom: Boolean = true) {
        NumericOptionsDialogFragment(component, isFrom).show(fragmentManager, NUMERIC_OPTION_FRAGMENT)
    }

    companion object {
        private const val NUMERIC_OPTION_FRAGMENT = "numeric_option_dialog_fragment"
    }

}
