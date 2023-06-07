package com.assignment.opensooq.features.filter.presentation.component.viewhodlers

import android.view.Gravity
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.assignment.opensooq.R
import com.assignment.opensooq.databinding.RowListBooleanBinding
import com.assignment.opensooq.features.categories.domain.model.category.TopicFilterModel
import com.assignment.opensooq.features.categories.domain.model.option.OptionLocalResponse
import com.google.android.flexbox.FlexboxLayout

class ListBooleanViewHolder(
    private val binding: RowListBooleanBinding
) : BaseFilterViewHolder(binding.root) {

    override fun bind(topicFilterModel: TopicFilterModel) {
        binding.model = topicFilterModel
        handleOptions(topicFilterModel.optionList)
    }

    private fun handleOptions(optionList: List<OptionLocalResponse>) {
        optionList.forEach {
            val textViewOption = textProperties(it)
            binding.flexboxLayout.addView(textViewOption)
            initListener(textViewOption, it)
        }
    }

    private fun textProperties(
        it: OptionLocalResponse,
    ): TextView {
        val layoutParams = FlexboxLayout.LayoutParams(
            FlexboxLayout.LayoutParams.WRAP_CONTENT,
            FlexboxLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.flexGrow = 1.0f
        val context = binding.root.context
        val textViewOption = TextView(context)
        textViewOption.text = it.name
        textViewOption.gravity = Gravity.CENTER
        textViewOption.layoutParams = layoutParams
        textViewOption.background = ContextCompat.getDrawable(context, R.drawable.background_text_option)
        return textViewOption
    }

    private fun initListener(textViewOption: TextView, optionLocalResponse: OptionLocalResponse) {
        val context = binding.root.context
        textViewOption.setOnClickListener {
            if (!optionLocalResponse.selected) {
                textViewOption.background =
                    ContextCompat.getDrawable(context, R.drawable.background_text_option_selected)
                textViewOption.setTextColor(ContextCompat.getColor(context, R.color.white))
                optionLocalResponse.selected = true
            } else {
                textViewOption.background =
                    ContextCompat.getDrawable(context, R.drawable.background_text_option)
                textViewOption.setTextColor(ContextCompat.getColor(context, R.color.dark_gray))
                optionLocalResponse.selected = false
            }
        }
    }


}
