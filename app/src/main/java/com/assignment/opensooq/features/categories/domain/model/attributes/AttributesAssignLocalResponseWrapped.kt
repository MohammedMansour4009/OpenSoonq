package com.assignment.opensooq.features.categories.domain.model.attributes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesAssignLocalResponseWrapped(

    @Json(name = "result")
    val result: ResultLocalResponse,

    @Json(name = "success")
    val success: Boolean

)