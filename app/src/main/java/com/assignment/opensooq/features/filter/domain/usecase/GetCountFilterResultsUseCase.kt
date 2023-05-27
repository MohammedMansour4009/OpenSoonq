package com.assignment.opensooq.features.filter.domain.usecase

import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import javax.inject.Inject

class GetCountFilterResultsUseCase @Inject constructor() {

    operator fun invoke(topicList: List<TopicFilterModel>): String {
        var filterResults = 0
        topicList.forEach {
            filterResults += it.optionList.size
        }
        return filterResults.toString()
    }

}