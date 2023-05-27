package com.assignment.opensooq.features.categories.presentation

import android.os.RemoteException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.opensooq.features.categories.domain.model.category.CategoryModelLocalResponse
import com.assignment.opensooq.features.categories.domain.model.category.SubCategoryLocalResponse
import com.assignment.opensooq.features.categories.domain.usecase.GetCategoriesUseCase
import com.assignment.opensooq.features.categories.domain.usecase.GetSubCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getSubCategoriesUseCase: GetSubCategoriesUseCase,
) : ViewModel() {

    private val _loadingState = MutableStateFlow(true)
    val loadingState: StateFlow<Boolean> = _loadingState

    private val _categoriesState = MutableStateFlow<List<CategoryModelLocalResponse>?>(null)
    val categoriesState: StateFlow<List<CategoryModelLocalResponse>?> = _categoriesState


    private val _errorState = MutableSharedFlow<Exception>()
    val errorState = _errorState.asSharedFlow()

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        _loadingState.emit(true)
        try {
            _categoriesState.emit(getCategoriesUseCase())
        } catch (exception: Exception) {
            _errorState.emit(exception)
        }
        _loadingState.emit(false)
    }

    fun getSubCategories(id: Int): List<SubCategoryLocalResponse>? {
        return getSubCategoriesUseCase(_categoriesState.value, id)
    }

}