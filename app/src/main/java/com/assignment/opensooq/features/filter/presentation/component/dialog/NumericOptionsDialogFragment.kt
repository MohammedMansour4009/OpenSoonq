package com.assignment.opensooq.features.filter.presentation.component.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.assignment.opensooq.databinding.DialogFragmentNumericOptionBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.adapter.NumericOptionAdapter

class NumericOptionsDialogFragment(
    private val topicLocalModel: TopicFilterModel
) : DialogFragment() {

    private lateinit var binding: DialogFragmentNumericOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentNumericOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogFragmentNumericOptionBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(requireActivity())
        alertDialogBuilder.setView(binding.root)
        val adapter = NumericOptionAdapter(
            requireParentFragment(),
            topicLocalModel
        )
        binding.viewPagerNumericOption.adapter = adapter

        initListener()
        return alertDialogBuilder.create()
    }

    private fun initListener() {
        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }


}