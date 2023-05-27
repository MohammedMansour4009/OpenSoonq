package com.assignment.opensooq.features.categories.domain.model.attributes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchFlowLocalResponse(

    @Json(name = "category_id")
    val categoryId: Int,

    @Json(name = "order")
    val order: List<String>
)