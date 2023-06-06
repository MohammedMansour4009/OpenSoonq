package com.assignment.opensooq.features.filter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.assignment.opensooq.R
import com.assignment.opensooq.core.coroutines.collect
import com.assignment.opensooq.databinding.FragmentNumericOptionBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse
import com.assignment.opensooq.features.filter.presentation.component.dialog.adapter.NumericOptionAdapter

class NumericOptionFragment(
    private val topicLocalModel: TopicFilterModel,
    private val onItemSelected: () -> Unit,
    private val position: Int
) : Fragment() {

    private lateinit var binding: FragmentNumericOptionBinding
    private lateinit var adapter: NumericOptionAdapter
    private val viewModel: FilterViewModel by viewModels(ownerProducer = { requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumericOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initViews()
        initObserver()
    }

    private fun initAdapter() {
        adapter = NumericOptionAdapter(ArrayList(topicLocalModel.optionList), ::onClickItem)
    }

    private fun initObserver() {
        viewModel.numericOptionSearch.collect(viewLifecycleOwner, ::onNumericOptionSearch)
    }

    private fun onNumericOptionSearch(input: String) {
        adapter.search(input, ::onSearchNothingFound)
    }

    private fun onSearchNothingFound() {
        Toast.makeText(requireContext(), getString(R.string.nothing_found), Toast.LENGTH_SHORT).show()
    }

    private fun initViews() {
        binding.recyclerView.adapter = adapter
        binding.title = topicLocalModel.name
    }

    private fun onClickItem(optionLocalResponse: OptionLocalResponse) {
        updateItemSelected(optionLocalResponse)
        resetLastSelected(optionLocalResponse)
        viewModel.updateOptions(topicLocalModel)
        onItemSelected()
    }

    private fun resetLastSelected(optionLocalResponse: OptionLocalResponse) {
        topicLocalModel.optionList.forEach {
            if (it.id == optionLocalResponse.id) {
                it.numericOptionValue = optionLocalResponse.numericOptionValue
                it.selected = true
            } else {
                it.selected = false
            }
        }
    }

    private fun updateItemSelected(optionLocalResponse: OptionLocalResponse) {
        val itemSelected = topicLocalModel.optionList.firstOrNull { it.selected }?.numericOptionValue
        optionLocalResponse.apply {
            numericOptionValue = if (position == 0) {
                Pair(name, itemSelected?.second)
            } else {
                Pair(itemSelected?.first, name)
            }
        }
    }

}