package com.assignment.opensooq.features.categories.domain.model.option

import android.os.Parcelable
import com.assignment.opensooq.BuildConfig
import com.assignment.opensooq.core.base.BaseAdapter
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class OptionLocalResponse(

    @Json(name = "field_id")
    val fieldId: String,

    @Json(name = "id")
    val id: String,

    @Json(name = "label")
    val label: String,

    @Json(name = "label_en")
    val name: String,

    @Json(name = "option_img")
    val optionImg: String?,

    @Json(name = "order")
    val order: String,

    @Json(name = "parent_id")
    val parentId: String?,

    @Json(name = "value")
    val value: String,

    var selected: Boolean = false,

    @Transient
    var numericOptionValue: Pair<String?, String?>? = null

) : Parcelable, BaseAdapter.Searchable {

    override fun getSearchCriteria(): String {
        return name
    }

    fun getFullImage() = optionImg?.let { BuildConfig.IMAGE_BASE_URL + optionImg }
}