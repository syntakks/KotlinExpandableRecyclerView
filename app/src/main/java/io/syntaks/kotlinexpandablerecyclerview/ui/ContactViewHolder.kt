package io.syntaks.kotlinexpandablerecyclerview.ui

import android.view.View
import io.syntaks.kotlinexpandablerecyclerview.data.Contact
import kotlinx.android.synthetic.main.list_item_contact.view.*

class ContactViewHolder(private val itemView: View, private val listItemListener: ContactListItemListener) : BaseViewHolder<Contact>(itemView), View.OnClickListener {
    private val cardView = itemView.cardView
    private val circleLabel = itemView.contactLabel

    override fun bind(item: Contact) {
        cardView.setOnClickListener(this)
        circleLabel.text = item.name
    }

    override fun onClick(v: View?) {
        listItemListener.contactSelected()
    }
}