package com.assignment.opensooq.features.categories.domain.model.category

import android.os.Parcelable
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse
import kotlinx.parcelize.Parcelize


@Parcelize
data class TopicFilterModel(
    val key: String? = null,
    var fieldName: String? = null,
    var name: String? = null,
    var componentType: TopicTypeModel = TopicTypeModel.LIST_STRING,
    var id: Int? = null,
    var optionList: List<OptionLocalResponse> = emptyList(),
    var selected: Boolean = false
) : Parcelable