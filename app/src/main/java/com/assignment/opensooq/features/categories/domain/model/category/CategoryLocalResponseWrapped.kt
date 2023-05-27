package com.assignment.opensooq.features.categories.domain.model.category

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryLocalResponseWrapped(

    @Json(name = "success")
    val success: Boolean,

    @Json(name = "result")
    val result: ResultLocalResponse,

    )