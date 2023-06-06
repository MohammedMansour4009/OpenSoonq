package com.assignment.opensooq.features.filter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.domain.usecase.GetCountFilterResultsUseCase
import com.assignment.opensooq.features.filter.domain.usecase.GetTopicFilterIndexUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val getCountFilterResultsUseCase: GetCountFilterResultsUseCase,
    private val getTopicFilterIndexUseCase: GetTopicFilterIndexUseCase,
) : ViewModel() {


    private val _optionsState = MutableSharedFlow<TopicFilterModel>()
    val optionsState = _optionsState.asSharedFlow()


    private val _numericOptionSearchState = MutableSharedFlow<String>()
    val numericOptionSearch = _numericOptionSearchState.asSharedFlow()


    fun getCountFilterResults(topicList: List<TopicFilterModel>): String {
        return getCountFilterResultsUseCase(topicList)
    }

    fun updateOptions(localResponses: TopicFilterModel) {
        viewModelScope.launch {
            _optionsState.emit(localResponses)
        }
    }

    fun getTopicFilterIndex(topicList: List<TopicFilterModel>, topicFilterModel: TopicFilterModel): Int {
        return getTopicFilterIndexUseCase(topicList, topicFilterModel)
    }

    fun onNumericOptionSearch(input: String) {
        viewModelScope.launch {
            _numericOptionSearchState.emit(input)
        }
    }

}