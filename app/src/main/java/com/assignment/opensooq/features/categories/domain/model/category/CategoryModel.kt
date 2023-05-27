package com.assignment.opensooq.features.categories.domain.model.category

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class CategoryModel(
    @PrimaryKey
    var id: String? = ObjectId().toHexString(),

    var hasChild: Int? = null,

    @Required
    var name: String = "",

    @Required
    var icon: String = "",

) : RealmObject()

