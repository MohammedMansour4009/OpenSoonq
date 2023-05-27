package com.assignment.opensooq.features.filter.presentation

import androidx.lifecycle.ViewModel
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.domain.usecase.GetCountFilterResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val getCountFilterResultsUseCase: GetCountFilterResultsUseCase,
) : ViewModel() {

    fun getCountFilterResults(topicList: List<TopicFilterModel>): String {
        return getCountFilterResultsUseCase(topicList)
    }

}