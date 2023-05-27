package com.assignment.opensooq.features.categories.domain.model.option

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FieldLocalResponse(

    @Json(name = "data_type")
    val dataType: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "parent_id")
    val parentId: Int,

    @Json(name = "parent_name")
    val parentName: String?
)