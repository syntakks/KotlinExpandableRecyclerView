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
    private val contactView: View,
    private val listItemListener: ContactListItemListener
) : BaseViewHolder<Contact>(contactView), View.OnClickListener {
    private val cardView = contactView.cardView
    private val circleLabel = contactView.contactLabel

    override fun bind(item: Contact) {
        cardView.setOnClickListener(this)
        circleLabel.text = item.name
        if (item.selected) {
            cardView.setCardBackgroundColor(
                ColorHelper.stateListForColorResource(
                    contactView.context.resources.getColor(
                        R.color.secondaryLightColor, null
                    )
                )
            )
        } else {
            cardView.setCardBackgroundColor(
                ColorHelper.stateListForColorResource(
                    contactView.context.resources.getColor(
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