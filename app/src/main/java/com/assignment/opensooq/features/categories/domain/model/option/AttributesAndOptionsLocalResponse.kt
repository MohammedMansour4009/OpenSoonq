package com.assignment.opensooq.features.categories.domain.model.option

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesAndOptionsLocalResponse(

    @Json(name = "fields")
    val fields: List<FieldLocalResponse>,

    @Json(name = "options")
    val options: List<OptionLocalResponse>
)