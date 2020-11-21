package io.syntaks.kotlinexpandablerecyclerview.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.syntaks.kotlinexpandablerecyclerview.R
import io.syntaks.kotlinexpandablerecyclerview.data.Circle
import io.syntaks.kotlinexpandablerecyclerview.data.Contact
import io.syntaks.kotlinexpandablerecyclerview.data.ContactsCache

private const val TAG = "ContactsAdapter"

class ContactsAdapter(private val contactsCache: ContactsCache) : RecyclerView.Adapter<BaseViewHolder<*>>(), CircleListItemListener, ContactListItemListener {
    private val data: MutableList<Any>
    private var toggleInProgress = false

    companion object {
        private const val TYPE_CIRCLE = 0
        private const val TYPE_CONTACT = 1
    }

    init {
        data = ArrayList()
        data.addAll(contactsCache.circles)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_CIRCLE -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item_circle, viewGroup, false)
                CircleViewHolder(view, this)
            }
            TYPE_CONTACT -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item_contact, viewGroup, false)
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

    override fun toggleCircle(position: Int) {
        Log.d(TAG, "toggleCircle")
        if (toggleInProgress) return

        if (data[position] is Circle) {
            toggleInProgress = true
            val circle = data[position] as Circle
            val circleContacts = contactsCache.getContactsForCircle(position)
            val start = position + 1
            if (circle.expanded) {
                // Remove
                for (i in circleContacts.indices) {
                    data.removeAt(start)
                }
                notifyItemRangeRemoved(start, circleContacts.size)
            } else {
                // Add
                data.addAll(start, circleContacts)
                notifyItemRangeInserted(start, circleContacts.size)
            }
            circle.expanded = !circle.expanded
            toggleInProgress = false
        }
    }

    override fun contactSelected() {
        Log.d(TAG, "contactSelected: ")
    }


}
