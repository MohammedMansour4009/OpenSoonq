package com.assignment.opensooq.features.filter.presentation.component.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.assignment.opensooq.databinding.RowListNumericBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.viewhodlers.BaseFilterViewHolder
import com.assignment.opensooq.features.filter.presentation.component.viewhodlers.NumericViewHolder

class ListNumericViewHolderFactory : BaseViewHolderFactory {

    override fun create(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        order: List<TopicFilterModel>,
        fragmentManager: FragmentManager
    ): BaseFilterViewHolder {
        return NumericViewHolder(
            RowListNumericBinding.inflate(layoutInflater, parent, false),
            fragmentManager
        )
    }
}

