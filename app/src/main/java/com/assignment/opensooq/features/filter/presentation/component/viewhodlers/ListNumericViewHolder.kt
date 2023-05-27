package com.assignment.opensooq.features.filter.presentation.component.viewhodlers

import androidx.fragment.app.FragmentManager
import com.assignment.opensooq.databinding.RowListNumericBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.dialog.NumericOptionsDialogFragment

class ListNumericViewHolder(
    private val binding: RowListNumericBinding,
    private val fragmentManager: FragmentManager
) : BaseFilterViewHolder(binding.root) {

    override fun bind(topicFilterModel: TopicFilterModel) {
        binding.model = topicFilterModel
        initListener(topicFilterModel)
    }

    private fun initListener(component: TopicFilterModel) {
        binding.textViewFrom.setOnClickListener {
            showNumericOptionsDialog(component)
        }
        binding.textViewFrom.setOnClickListener {
            showNumericOptionsDialog(component)
        }
    }

    private fun showNumericOptionsDialog(component: TopicFilterModel) {
        NumericOptionsDialogFragment(component).show(fragmentManager, NUMERIC_OPTION_FRAGMENT)
    }

    companion object{
        private const val NUMERIC_OPTION_FRAGMENT = "numeric_option_dialog_fragment"
    }

}
