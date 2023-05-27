package com.assignment.opensooq.features.categories.data.di

import com.assignment.opensooq.features.categories.data.CategoriesRepositoryImpl
import com.assignment.opensooq.features.categories.domain.CategoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CategoriesFeatureModule {

    @Binds
    fun bindsCategoriesRepo(impl: CategoriesRepositoryImpl): CategoriesRepository
}