package com.assignment.opensooq.features.filter.domain.usecase

import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import javax.inject.Inject

class ResetTopicsFilterUseCase @Inject constructor() {

    operator fun invoke(topicList: List<TopicFilterModel>): ArrayList<Int> {
        val indexItemReset = ArrayList<Int>()
        topicList.forEachIndexed { index, topicFilterModel ->
            topicFilterModel.optionList.forEach {
                if (it.selected) {
                    it.selected = false
                    if (!indexItemReset.contains(index))
                        indexItemReset.add(index)
                }
            }
        }
        return indexItemReset
    }

}