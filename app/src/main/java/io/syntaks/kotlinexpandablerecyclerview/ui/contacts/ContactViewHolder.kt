package io.syntaks.kotlinexpandablerecyclerview.ui.contacts

import android.util.Log
import android.view.View
import io.syntaks.kotlinexpandablerecyclerview.R
import io.syntaks.kotlinexpandablerecyclerview.data.Contact
import io.syntaks.kotlinexpandablerecyclerview.ui.shared.BaseViewHolder
import io.syntaks.kotlinexpandablerecyclerview.ui.shared.ColorHelper
import kotlinx.android.synthetic.main.list_item_contact.view.*

private const val TAG = "ContactViewHolder"

class ContactViewHolder(
    private val itemView: View,
    private val listItemListener: ContactListItemListener
) : BaseViewHolder<Contact>(itemView), View.OnClickListener {
    private val cardView = itemView.cardView
    private val circleLabel = itemView.contactLabel

    override fun bind(item: Contact) {
        cardView.setOnClickListener(this)
        circleLabel.text = item.name
        if (item.selected) {
            cardView.setCardBackgroundColor(
                ColorHelper.stateListForColorResource(
                    itemView.context.resources.getColor(
                        R.color.purple_700, null
                    )
                )
            )
        } else {
            cardView.setCardBackgroundColor(
                ColorHelper.stateListForColorResource(
                    itemView.context.resources.getColor(
                        R.color.white, null
                    )
                )
            )
        }
    }

    override fun onClick(v: View?) {
        Log.d(TAG, "onClick: ")
        listItemListener.toggleContactSelected(adapterPosition)
    }
}