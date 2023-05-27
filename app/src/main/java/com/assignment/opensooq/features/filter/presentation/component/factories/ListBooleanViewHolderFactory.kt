package com.assignment.opensooq.features.filter.presentation.component.factories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.assignment.opensooq.databinding.RowListBooleanBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.viewhodlers.BaseFilterViewHolder
import com.assignment.opensooq.features.filter.presentation.component.viewhodlers.ListBooleanViewHolder

class ListBooleanViewHolderFactory : BaseViewHolderFactory {

    override fun create(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        order: List<TopicFilterModel>,
        fragmentManager: FragmentManager
    ): BaseFilterViewHolder {
        return ListBooleanViewHolder(
            RowListBooleanBinding.inflate(layoutInflater, parent, false)
        )
    }
}

