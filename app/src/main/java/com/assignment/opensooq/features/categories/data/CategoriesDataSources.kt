package com.assignment.opensooq.features.categories.data

import android.app.Application
import androidx.annotation.RawRes
import com.assignment.opensooq.R
import com.assignment.opensooq.features.categories.domain.model.FilterLocalResponseWrapped
import com.assignment.opensooq.features.categories.domain.model.attributes.AttributesAssignLocalResponseWrapped
import com.assignment.opensooq.features.categories.domain.model.category.CategoryLocalResponseWrapped
import com.assignment.opensooq.features.categories.domain.model.option.AttributesAndOptionsLocalResponseWrapped
import com.squareup.moshi.Moshi
import javax.inject.Inject

class CategoriesDataSources @Inject constructor(
    val context: Application, val moshi: Moshi
) {

    fun getFilterLocalResponse(): FilterLocalResponseWrapped {
        val categoriseJson = getJson(R.raw.categories)
        val categoriseModel =
            getModelLocalResponses(CategoryLocalResponseWrapped::class.java, categoriseJson).result.data.categories

        val attributesAssignJson = getJson(R.raw.attributes_assign)
        val attributesAssignModel =
            getModelLocalResponses(AttributesAssignLocalResponseWrapped::class.java, attributesAssignJson).result.data

        val attributesAndOptionsJson = getJson(R.raw.attributes_and_options)
        val attributesAndOptionsModel =
            getModelLocalResponses(AttributesAndOptionsLocalResponseWrapped::class.java, attributesAndOptionsJson)
                .result.data
        
        return FilterLocalResponseWrapped(categoriseModel, attributesAssignModel, attributesAndOptionsModel)
    }

    private fun <T> getModelLocalResponses(type: Class<T>, categoriseJson: String) =
        moshi.adapter(type).fromJson(categoriseJson)!!

    private fun getJson(@RawRes id: Int): String {
        return context.resources.openRawResource(id).bufferedReader().use { it.readText() }
    }
    
}
