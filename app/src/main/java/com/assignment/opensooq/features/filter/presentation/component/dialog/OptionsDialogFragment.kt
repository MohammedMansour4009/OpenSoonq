package com.assignment.opensooq.features.filter.presentation.component.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.assignment.opensooq.databinding.DialogFragmentOptionBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.adapter.OptionAdapter

class OptionsDialogFragment(private val topicLocalModel: TopicFilterModel) : DialogFragment() {

    private lateinit var binding: DialogFragmentOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogFragmentOptionBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(requireActivity())
        alertDialogBuilder.setView(binding.root)
        binding.recyclerView.adapter = OptionAdapter(topicLocalModel.optionList)
        binding.model = topicLocalModel
        return alertDialogBuilder.create()
    }


}