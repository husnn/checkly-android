package com.husnainjaved.checkly

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ChecklyAdapter(private val context: Context, var options: ArrayList<ChecklyOption>) :
    RecyclerView.Adapter<ChecklyAdapter.ChecklyTagViewHolder>() {

    var optionToggled: ((ChecklyOption) -> Unit)? = null
    var optionsUpdated: ((List<ChecklyOption>) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChecklyTagViewHolder =
        ChecklyTagViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.checkly_tag, parent, false)
        )

    override fun onBindViewHolder(holder: ChecklyTagViewHolder, position: Int) {
        holder.bind(options[position])
    }

    override fun getItemCount(): Int = options.size

    fun setOptions(options: List<ChecklyOption>) {
        this.options = ArrayList(options)
        notifyDataSetChanged()
    }

    inner class ChecklyTagViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val container = itemView.findViewById<RelativeLayout>(R.id.container)
        private val label = itemView.findViewById<TextView>(R.id.tv_label)
        private val tick = itemView.findViewById<ImageView>(R.id.iv_tick)

        fun bind(option: ChecklyOption) {
            label.text = option.name

            when (option.selected) {
                true -> {
                    container.setBackgroundResource(R.drawable.checkly_tag_bg_selected)
                    label.setTextColor(ContextCompat.getColor(context, android.R.color.white))
                    tick.visibility = View.VISIBLE
                }
                else -> {
                    container.setBackgroundResource(R.drawable.checkly_tag_bg_normal)
                    label.setTextColor(ContextCompat.getColor(context, R.color.black))
                    tick.visibility = View.GONE
                }
            }

            itemView.setOnClickListener {
                option.selected = !option.selected
                optionToggled?.invoke(option)

                notifyItemChanged(adapterPosition)
                optionsUpdated?.invoke(options)
            }
        }
    }
}