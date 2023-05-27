package com.assignment.opensooq.features.categories.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.assignment.opensooq.R
import com.assignment.opensooq.core.coroutines.collect
import com.assignment.opensooq.databinding.FragmentCategoriesBinding
import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding
    private val viewModel: CategoriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initView()
    }

    private fun initView() {
        binding.toolbarCategory.title = getString(R.string.select_category)
        binding.toolbarCategory.enableClose = true
    }

    private fun initObserver() {
        viewModel.categoriesState.collect(viewLifecycleOwner, ::handleCategories)
        viewModel.errorState.collect(viewLifecycleOwner, ::handleExpectedErrorMessage)
        viewModel.loadingState.collect(viewLifecycleOwner, ::handleProgress)
    }

    private fun handleCategories(categories: List<CategoryModelLocalResponse>?) {
        if (categories != null) {
            binding.recyclerViewCategories.adapter = CategoriesAdapter(categories, ::onClickCategories)
        }
    }

    private fun handleExpectedErrorMessage(exception: Exception) {
        Toast.makeText(requireContext(), exception.localizedMessage, Toast.LENGTH_LONG).show()
    }

    private fun handleProgress(show: Boolean) {
        binding.progressBar.isVisible = show
    }

    private fun onClickCategories(model: CategoryModelLocalResponse) {
        val subCategories = viewModel.getSubCategories(model.id)

        if (subCategories != null) {
            val bundle = Bundle()
            bundle.putParcelableArrayList(SUB_CATEGORIES, ArrayList(subCategories))
            bundle.putString(TITLE_SUB_CATEGORIES, model.name)
            findNavController().navigate(R.id.subCategoryFragment, bundle)

        } else {
            Toast.makeText(requireContext(), R.string.no_item, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val SUB_CATEGORIES = "subCategories"
        const val TITLE_SUB_CATEGORIES = "titleSubCategories"
    }
}