package io.syntaks.kotlinexpandablerecyclerview.ui.contacts

import android.util.Log
import android.view.View
import io.syntaks.kotlinexpandablerecyclerview.R
import io.syntaks.kotlinexpandablerecyclerview.data.Circle
import io.syntaks.kotlinexpandablerecyclerview.ui.shared.BaseViewHolder
import io.syntaks.kotlinexpandablerecyclerview.ui.shared.ColorHelper
import kotlinx.android.synthetic.main.list_item_circle.view.*

private const val TAG = "CircleViewHolder"

class CircleViewHolder(
    private val circleView: View,
    private val listItemListener: CircleListItemListener
) : BaseViewHolder<Circle>(circleView), View.OnClickListener, View.OnLongClickListener {
    private var cardView = circleView.cardView
    private val circleLabel = circleView.circleLabel

    override fun bind(item: Circle) {
        Log.d(TAG, "bind: ")
        cardView.setOnClickListener(this)
        cardView.setOnLongClickListener(this)
        circleLabel.text = item.name
        if (item.selected) {
            cardView.setCardBackgroundColor(
                ColorHelper.stateListForColorResource(
                    circleView.context.resources.getColor(
                        R.color.secondaryLightColor,
                        null
                    )
                )
            )
        } else {
            cardView.setCardBackgroundColor(
                ColorHelper.stateListForColorResource(
                    circleView.context.resources.getColor(
                        R.color.white,
                        null
                    )
                )
            )
        }
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "onClick: ")
        listItemListener.toggleCircleExpanded(adapterPosition)
    }

    override fun onLongClick(v: View?): Boolean {
        Log.d(TAG, "onLongClick: ")
        listItemListener.toggleCircleSelection(adapterPosition)
        return false
    }
}