package com.assignment.opensooq.features.categories.domain.model.option

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class AttributesAndOptionsLocalResponseWrapped(

    @Json(name = "result")
    val result: ResultLocalResponse

)