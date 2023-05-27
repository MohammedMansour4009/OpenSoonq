package com.assignment.opensooq.features.categories.domain.usecase

import com.assignment.opensooq.features.categories.domain.CategoriesRepository
import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {

    suspend operator fun invoke(): List<CategoryModelLocalResponse>? {
        return repository.getCategories()
    }

}