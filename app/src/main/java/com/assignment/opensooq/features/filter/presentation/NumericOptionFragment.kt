package com.assignment.opensooq.features.filter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.opensooq.databinding.FragmentNumericOptionBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.filter.presentation.component.adapter.NumericAdapter

class NumericOptionFragment(private val topicLocalModel: TopicFilterModel) : Fragment() {

    private lateinit var binding: FragmentNumericOptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNumericOptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = NumericAdapter(topicLocalModel.optionList)
        binding.title = topicLocalModel.name
    }


}