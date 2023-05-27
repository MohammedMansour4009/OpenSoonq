package com.assignment.opensooq.features.categories.domain.model.attributes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FieldsLabelLocalResponse(

    @Json(name = "field_name")
    val fieldName: String,

    @Json(name = "label_en")
    val labelEn: String

)