package com.assignment.opensooq.features.filter.presentation.component.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.assignment.opensooq.R
import com.assignment.opensooq.databinding.DialogFragmentOptionBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.FilterViewModel
import com.assignment.opensooq.features.filter.presentation.component.adapter.OptionAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OptionsDialogFragment(private val topicLocalModel: TopicFilterModel) : DialogFragment() {

    private lateinit var binding: DialogFragmentOptionBinding
    private val viewModel: FilterViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        binding = DialogFragmentOptionBinding.inflate(layoutInflater)
        val alertDialogBuilder = AlertDialog.Builder(requireActivity())
        alertDialogBuilder.setView(binding.root)
        val adapter = OptionAdapter(ArrayList(topicLocalModel.optionList))
        binding.recyclerView.adapter = adapter
        binding.model = topicLocalModel
        initListener(adapter)
        return alertDialogBuilder.create()
    }

    private fun initListener(adapter: OptionAdapter) {
        binding.buttonReset.setOnClickListener {
            adapter.resetOptions()
            viewModel.updateOptions(topicLocalModel)
        }
        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
        binding.buttonDone.setOnClickListener {
            viewModel.updateOptions(topicLocalModel)
            dismiss()
        }

        binding.editTextSearchView.addTextChangedListener {
            adapter.search(it.toString(), ::onSearchNothingFound)
        }
    }

    private fun onSearchNothingFound() {
        Toast.makeText(requireContext(), getString(R.string.nothing_found), Toast.LENGTH_SHORT).show()
    }


}