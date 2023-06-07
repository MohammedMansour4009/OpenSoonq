package com.assignment.opensooq.features.filter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.assignment.opensooq.core.coroutines.collect
import com.assignment.opensooq.core.extension.parcelableArrayList
import com.assignment.opensooq.databinding.FragmentFilterBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.adapter.FilterAdapter
import com.assignment.opensooq.features.subcategories.presentation.SubCategoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding
    private val viewModel: FilterViewModel by viewModels()
    private lateinit var filterAdapter: FilterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFilterBinding.inflate(layoutInflater)
        initData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObserver()
    }

    private fun initObserver() {
        viewModel.topicsState.collect(viewLifecycleOwner, ::handleTopicsSuccess)
        viewModel.resetTopicsState.collect(viewLifecycleOwner, ::handelResetTopics)
        viewModel.optionsState.collect(viewLifecycleOwner, ::onUpdateCarType)
    }

    private fun handleTopicsSuccess(topicFilterModel: List<TopicFilterModel>?) {
        if (topicFilterModel == null) return

        initAdapter(topicFilterModel)
        handleFilterResultsCount(topicFilterModel)
    }

    private fun initAdapter(topicFilterModel: List<TopicFilterModel>) {
        filterAdapter = FilterAdapter(topicFilterModel, childFragmentManager)
        binding.recyclerViewFilter.adapter = filterAdapter

        val layoutManager = binding.recyclerViewFilter.layoutManager as GridLayoutManager
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {

            override fun getSpanSize(position: Int): Int {
                return filterAdapter.getSpanCount(position)
            }
        }
    }

    private fun onUpdateCarType(topicFilterModel: TopicFilterModel) {
        val position = viewModel.getTopicFilterIndex(topicFilterModel)
        filterAdapter.notifyItemChanged(position)
    }

    private fun handelResetTopics(index: List<Int>) {
        index.forEach {
            filterAdapter.notifyItemChanged(it)
        }
    }

    private fun initListener() {
        binding.toolbarFilter.imageViewBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        binding.buttonReset.setOnClickListener {
            viewModel.resetData()
        }
    }

    private fun initData() {
        val topicsFilter =
            (arguments?.parcelableArrayList<TopicFilterModel>(SubCategoryFragment.ORDERS)?.toList() ?: emptyList())
        viewModel.fillTopics(topicsFilter)
    }

    private fun handleFilterResultsCount(topicList: List<TopicFilterModel>) {
        binding.filterResults = viewModel.getCountFilterResults(topicList)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.resetData()
    }


}