package com.assignment.opensooq.features.categories.domain.model.option

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultLocalResponse(

    @Json(name = "data")
    val data: AttributesAndOptionsLocalResponse,

    @Json(name = "hash")
    val hash: String,

    @Json(name = "status")
    val status: Int
)