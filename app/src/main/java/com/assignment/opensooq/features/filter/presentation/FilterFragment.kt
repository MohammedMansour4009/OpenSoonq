package com.assignment.opensooq.features.filter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.assignment.opensooq.core.extension.parcelableArrayList
import com.assignment.opensooq.databinding.FragmentFilterBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.adapter.FilterAdapter
import com.assignment.opensooq.features.subcategories.presentation.SubCategoryFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : Fragment() {

    private lateinit var binding: FragmentFilterBinding
    private lateinit var topicList: List<TopicFilterModel>
    private val viewModel: FilterViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        initData()
        binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.toolbarFilter.imageViewBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    private fun initData() {
        topicList =
            (arguments?.parcelableArrayList<TopicFilterModel>(SubCategoryFragment.ORDERS)?.toList() ?: emptyList())

        val homeComponentAdapter = FilterAdapter(topicList, childFragmentManager)

        binding.recyclerViewFilter.adapter = homeComponentAdapter
        val layoutManager = binding.recyclerViewFilter.layoutManager as GridLayoutManager
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {

            override fun getSpanSize(position: Int): Int {
                return homeComponentAdapter.getSpanCount(position)
            }
        }
        handleFilterResults(topicList)

    }

    private fun handleFilterResults(topicList: List<TopicFilterModel>) {
        binding.filterResults = viewModel.getCountFilterResults(topicList)
    }
}