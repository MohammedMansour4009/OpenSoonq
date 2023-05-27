package com.assignment.opensooq.features.categories.domain

import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse

interface CategoriesRepository {
    suspend fun getCategories(): List<CategoryModelLocalResponse>?
}