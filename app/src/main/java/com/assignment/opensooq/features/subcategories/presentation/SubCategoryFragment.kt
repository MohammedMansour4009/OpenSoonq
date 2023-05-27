package com.assignment.opensooq.features.subcategories.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.assignment.opensooq.R
import com.assignment.opensooq.core.extension.parcelableArrayList
import com.assignment.opensooq.databinding.FragmentSubcategoryBinding
import com.assignment.opensooq.features.categories.domain.model.category.SubCategoryLocalResponse
import com.assignment.opensooq.features.categories.presentation.CategoriesFragment.Companion.SUB_CATEGORIES
import com.assignment.opensooq.features.categories.presentation.CategoriesFragment.Companion.TITLE_SUB_CATEGORIES
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubCategoryFragment : Fragment() {

    private lateinit var binding: FragmentSubcategoryBinding
    private lateinit var subCategories: List<SubCategoryLocalResponse>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        initData()
        binding = FragmentSubcategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAdapter()
        initListener()
    }

    private fun initListener() {
        binding.toolbarSubcategory.imageViewBack.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    private fun initView() {
        binding.toolbarSubcategory.title = getString(R.string.select_subcategory)
        binding.textViewTitle.text = arguments?.getString(TITLE_SUB_CATEGORIES)
    }

    private fun initAdapter() {
        if (subCategories.isNotEmpty()) {
            binding.recyclerViewSubcategory.adapter = SubCategoryAdapter(subCategories.toList(), ::onClickCategories)
        } else {
            Toast.makeText(requireContext(), R.string.no_item, Toast.LENGTH_LONG).show()
        }
    }

    private fun initData() {
        subCategories =
            arguments?.parcelableArrayList<SubCategoryLocalResponse>(SUB_CATEGORIES)?.toList() ?: emptyList()
    }

    private fun onClickCategories(model: SubCategoryLocalResponse) {
        if (model.filterTopics != null) {
            val bundle = Bundle()
            bundle.putParcelableArrayList(ORDERS, ArrayList(model.filterTopics!!))
            findNavController().navigate(R.id.filterFragment, bundle)
        } else {
            Toast.makeText(requireContext(), R.string.no_item, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val ORDERS = "orders"
    }

}