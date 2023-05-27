package com.assignment.opensooq.features.categories.domain.usecase

import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse
import com.assignment.opensooq.features.categories.domain.model.category.SubCategoryLocalResponse
import javax.inject.Inject

class GetSubCategoriesUseCase @Inject constructor() {

    operator fun invoke(items: List<CategoryModelLocalResponse>?, id: Int): List<SubCategoryLocalResponse>? {
        return items?.first{ it.id == id }?.subCategories
    }

}