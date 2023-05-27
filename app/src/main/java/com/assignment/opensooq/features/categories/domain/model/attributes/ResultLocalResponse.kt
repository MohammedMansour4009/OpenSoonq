package com.assignment.opensooq.features.categories.domain.model.attributes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultLocalResponse(

    @Json(name = "data")
    val data: AttributesAssignLocalResponse,

    )