package io.syntaks.kotlinexpandablerecyclerview.ui

import android.util.Log
import android.view.View
import io.syntaks.kotlinexpandablerecyclerview.data.Circle
import kotlinx.android.synthetic.main.list_item_circle.view.*

private const val TAG = "CircleViewHolder"

class CircleViewHolder(private val itemView: View, private val listItemListener: CircleListItemListener) : BaseViewHolder<Circle>(itemView), View.OnClickListener {
    private val cardView = itemView.cardView
    private val circleLabel = itemView.circleLabel

    override fun bind(item: Circle) {
        Log.d(TAG, "bind: ")
        cardView.setOnClickListener(this)
        circleLabel.text = item.name
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "onClick: ")
        listItemListener.toggleCircle(adapterPosition)
    }
}