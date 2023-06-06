package com.assignment.opensooq.features.filter.presentation.component.dialog.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.NumericOptionFragment

class NumericFragmentAdapter(
    fragment: Fragment,
    private val localResponse: TopicFilterModel,
    private val onItemSelected: () -> Unit,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return NumericOptionFragment(localResponse, onItemSelected, position)
    }
}
