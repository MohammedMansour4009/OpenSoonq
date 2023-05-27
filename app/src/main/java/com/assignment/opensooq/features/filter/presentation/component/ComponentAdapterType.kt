package com.assignment.opensooq.features.filter.presentation.component

import com.assignment.opensooq.features.filter.presentation.component.factories.BaseViewHolderFactory
import com.assignment.opensooq.features.filter.presentation.component.factories.ListBooleanViewHolderFactory
import com.assignment.opensooq.features.filter.presentation.component.factories.ListNumericViewHolderFactory
import com.assignment.opensooq.features.filter.presentation.component.factories.ListStringIconViewHolderFactory
import com.assignment.opensooq.features.filter.presentation.component.factories.ListStringViewHolderFactory

enum class ComponentAdapterType(val factory: BaseViewHolderFactory, val spanCount: Int = 0) {

    LIST_STRING(ListStringViewHolderFactory(),2),

    LIST_STRING_ICON(ListStringIconViewHolderFactory(),2),

    LIST_BOOLEAN(ListBooleanViewHolderFactory(),2),

    LIST_NUMERIC(ListNumericViewHolderFactory(),2)
}
