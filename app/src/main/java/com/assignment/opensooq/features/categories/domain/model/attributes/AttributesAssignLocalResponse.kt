package com.assignment.opensooq.features.categories.domain.model.attributes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AttributesAssignLocalResponse(

    @Json(name = "fields_labels")
    val fields_labels: List<FieldsLabelLocalResponse>,


    @Json(name = "search_flow")
    val searchFlow: List<SearchFlowLocalResponse>
)