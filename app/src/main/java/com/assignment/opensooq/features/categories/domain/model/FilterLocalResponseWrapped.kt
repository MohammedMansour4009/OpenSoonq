package com.assignment.opensooq.features.categories.domain.model

import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse
import com.assignment.opensooq.features.categories.domain.model.option.AttributesAndOptionsLocalResponse
import com.assignment.opensooq.features.categories.domain.model.attributes.AttributesAssignLocalResponse

data class FilterLocalResponseWrapped(

    val categoriseModel: List<CategoryModelLocalResponse>,

    val attributesAssignLocalResponse: AttributesAssignLocalResponse,

    val attributesAndOptionsLocalResponse: AttributesAndOptionsLocalResponse,
)