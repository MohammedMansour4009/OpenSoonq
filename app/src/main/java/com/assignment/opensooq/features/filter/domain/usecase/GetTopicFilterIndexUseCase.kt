package com.assignment.opensooq.features.filter.domain.usecase

import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import javax.inject.Inject

class GetTopicFilterIndexUseCase @Inject constructor() {

    operator fun invoke(topicList: List<TopicFilterModel>, topicFilterModel: TopicFilterModel): Int {
        topicList.forEachIndexed { index, filterModel ->
            if (filterModel.id == topicFilterModel.id) {
                return index
            }
        }
        return 0
    }

}