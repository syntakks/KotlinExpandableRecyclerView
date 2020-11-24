package io.syntaks.kotlinexpandablerecyclerview.ui.contacts

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.syntaks.kotlinexpandablerecyclerview.R
import io.syntaks.kotlinexpandablerecyclerview.data.Circle
import io.syntaks.kotlinexpandablerecyclerview.data.Contact
import io.syntaks.kotlinexpandablerecyclerview.data.ContactsCache
import io.syntaks.kotlinexpandablerecyclerview.ui.shared.BaseViewHolder

private const val TAG = "ContactsAdapter"

class ContactsAdapter(private val contactsListData: MutableList<Any>) :
    RecyclerView.Adapter<BaseViewHolder<*>>(),
    CircleListItemListener, ContactListItemListener {
    private val data: MutableList<Any> = contactsListData
    private var toggleInProgress = false
    private var selectionInProgress = false

    companion object {
        private const val TYPE_CIRCLE = 0
        private const val TYPE_CONTACT = 1
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_CIRCLE -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.list_item_circle, viewGroup, false)
                CircleViewHolder(view, this)
            }
            TYPE_CONTACT -> {
                val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.list_item_contact, viewGroup, false)
                ContactViewHolder(view, this)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: BaseViewHolder<*>, position: Int) {
        val element = data[position]
        when (viewHolder) {
            is CircleViewHolder -> viewHolder.bind(element as Circle)
            is ContactViewHolder -> viewHolder.bind(element as Contact)
            else -> throw IllegalArgumentException("Invalid type of data")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is Circle -> TYPE_CIRCLE
            is Contact -> TYPE_CONTACT
            else -> throw IllegalArgumentException("Invalid data type at position: $position")
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.size

    override fun toggleCircleExpanded(position: Int) {
        Log.d(TAG, "toggleCircle")
        if (toggleInProgress) return

        if (data[position] is Circle) {
            toggleInProgress = true
            val circle = data[position] as Circle
            // Sorted and reversed so I can add them to the same index in a loop maintaining sort order.
            val circleContacts = circle.contacts.sortedWith(compareBy(Contact::name)).reversed()
            val start = position + 1
            if (circle.expanded) {
                // Remove
                for (i in circleContacts.indices) {
                    if (data[start] is Contact)
                        data.removeAt(start)
                }
                notifyItemRangeRemoved(start, circleContacts.size)
            } else {
                // Add
                for (contact in circleContacts) {
                    contact.circleId = circle.id
                    data.add(start, contact)
                }
                notifyItemRangeInserted(start, circleContacts.size)
            }
            circle.expanded = !circle.expanded
            toggleInProgress = false
        }
    }

    // CircleListItemListener - OnLongClick
    override fun toggleCircleSelection(position: Int) {
        if (selectionInProgress) return
        selectionInProgress = true
        if (data[position] is Circle) {
            val circle = data[position] as Circle
            circle.toggleCircleSelection()
            updateContactCopies(circle.contacts, circle.selected)
            updateCirclesSelection()
            notifyDataSetChanged()
            selectionInProgress = false
        }
    }

    // ContactListItemListener - OnClick
    override fun toggleContactSelected(position: Int) {
        Log.d(TAG, "contactSelected: ")
        if (selectionInProgress) return
        selectionInProgress = true
        if (data[position] is Contact) {
            val contact = data[position] as Contact
            contact.selected = !contact.selected
            val circle = ContactsCache.getCircleById(contact.circleId)
            if (circle != null) {
                circle.contacts.find { c ->  c.id == contact.id}?.selected = contact.selected
            }
            updateContactCopies(listOf(contact), contact.selected)
            updateCirclesSelection()
            notifyDataSetChanged()
            selectionInProgress = false
        }
    }

    // Sync selection state for contact copies in list.
    private fun updateContactCopies(contacts: List<Contact>, selected: Boolean) {
        for (item in data) {
            if (item is Contact) {
                for (contact in contacts) {
                    if (item.id == contact.id) {
                        item.selected = selected
                    }
                }
            }
        }
    }

    // Sync selection state for circles in list
    private fun updateCirclesSelection() {
        for (item in data) {
            if (item is Circle) {
                item.selected = item.isCircleSelected()
            }
        }
    }


}
