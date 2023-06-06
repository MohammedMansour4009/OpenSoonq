package com.assignment.opensooq.features.filter.presentation.component.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.assignment.opensooq.R
import com.assignment.opensooq.databinding.DialogFragmentNumericOptionBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.FilterViewModel
import com.assignment.opensooq.features.filter.presentation.component.dialog.adapter.NumericFragmentAdapter
import com.google.android.material.tabs.TabLayoutMediator

class NumericOptionsDialogFragment(
    private val topicLocalModel: TopicFilterModel, private val isFromList: Boolean
) : DialogFragment() {

    private val viewModel: FilterViewModel by viewModels(ownerProducer = { requireParentFragment() })

    private lateinit var binding: DialogFragmentNumericOptionBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogFragmentNumericOptionBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(requireActivity())
        alertDialogBuilder.setView(binding.root)
        val adapter = NumericFragmentAdapter(
            requireParentFragment(),
            topicLocalModel,
            ::onItemSelected,
        )
        initViews(adapter)
        initListener()
        return alertDialogBuilder.create()
    }

    private fun initViews(adapter: NumericFragmentAdapter) {
        binding.viewPagerNumericOption.adapter = adapter
        binding.viewPagerNumericOption.setCurrentItem(if (isFromList) FROM_TAB else TO_TAB, false)
        TabLayoutMediator(
            binding.tabLayout, binding.viewPagerNumericOption, true, true
        ) { tab, position ->
            tab.text = if (position == FROM_TAB) getString(R.string.from) else getString(R.string.to)
        }.attach()
    }

    private fun onItemSelected() {
        if (binding.viewPagerNumericOption.currentItem == FROM_TAB)
            binding.viewPagerNumericOption.setCurrentItem(TO_TAB, true)
        else
            dismiss()
    }

    private fun initListener() {
        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
        binding.editTextSearchView.addTextChangedListener {
            viewModel.onNumericOptionSearch(it.toString())
        }
    }

    companion object {
        private const val  FROM_TAB = 0
        private const val  TO_TAB = 1
    }

}