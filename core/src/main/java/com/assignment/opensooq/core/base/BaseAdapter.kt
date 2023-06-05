package com.assignment.opensooq.core.base

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : BaseAdapter.Searchable, B : RecyclerView.ViewHolder>(private val searchableList: MutableList<T>) :
    RecyclerView.Adapter<B>(), Filterable {

    private val originalList = ArrayList(searchableList)
    private var onNothingFound: (() -> Unit)? = null


    fun search(searchText: String?, onNothingFound: (() -> Unit)? = {}) {
        this.onNothingFound = onNothingFound
        filter.filter(searchText)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                searchableList.clear()

                if (constraint.isNullOrBlank()) {
                    searchableList.addAll(originalList)
                } else {
                    val searchResults = originalList.filter { it.getSearchCriteria().contains(constraint, true) }
                    searchableList.addAll(searchResults)
                }
                return filterResults.also {
                    it.values = searchableList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (searchableList.isEmpty())
                    onNothingFound?.invoke()
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return searchableList.size
    }


    interface Searchable {
        fun getSearchCriteria(): String
    }
}