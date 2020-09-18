package com.husnainjaved.checkly

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class ChecklyView : RecyclerView {
    var selectionListener: ChecklySelectionListener? = null

    private var options: ArrayList<ChecklyOption> = arrayListOf()
    private var optionsAdapter: ChecklyAdapter

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        this.layoutManager = FlexboxLayoutManager(context).apply {
            flexDirection = FlexDirection.ROW
            justifyContent = JustifyContent.CENTER
        }

        optionsAdapter = ChecklyAdapter(context, options)

        this.adapter = optionsAdapter.apply {
            optionToggled = { option -> selectionListener?.onOptionToggled(option) }
            optionsUpdated = { options ->
                this.options = ArrayList(options)
                selectionListener?.onOptionsUpdated(options)
            }
        }
    }

    fun createTag(label: String) =
        ChecklyOption(
            id = RandomUtils.generateId(),
            name = label
        )

    fun addTag(label: String) {
        options.add(createTag(label))
        optionsAdapter.notifyItemChanged(options.size - 1)
    }

    fun addOption(option: ChecklyOption) {
        options.add(option)
        optionsAdapter.notifyItemChanged(options.size - 1)
    }

    fun setOptions(options: List<ChecklyOption>) {
        optionsAdapter.setOptions(options)
    }

    fun createTagList(labels: List<String>): List<ChecklyOption> =
        labels.map { createTag(it) }

    fun setLabels(labels: List<String>) {
        setOptions(createTagList(labels))
    }
}