package com.assignment.opensooq.features.filter.presentation.component.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.NumericOptionFragment

class NumericOptionAdapter(
    fragment: Fragment,
    private val localResponse: TopicFilterModel,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return NumericOptionFragment(localResponse)
    }
}
