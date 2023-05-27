package com.assignment.opensooq.features.categories.domain.model.category

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class CategoryModelLocalResponse(

    @Json(name = "has_child")
    val hasChild: Int,

    @Json(name = "icon")
    val icon: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "label_en")
    val name: String,

    @Json(name = "subCategories")
    val subCategories: List<SubCategoryLocalResponse>

) : Parcelable