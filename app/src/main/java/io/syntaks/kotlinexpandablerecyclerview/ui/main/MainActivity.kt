package io.syntaks.kotlinexpandablerecyclerview.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.Spanned
import android.text.style.ImageSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.ChipDrawable
import io.syntaks.kotlinexpandablerecyclerview.R
import io.syntaks.kotlinexpandablerecyclerview.data.Contact
import io.syntaks.kotlinexpandablerecyclerview.data.ContactsCache
import io.syntaks.kotlinexpandablerecyclerview.ui.contacts.ContactSearchListener
import io.syntaks.kotlinexpandablerecyclerview.ui.contacts.ContactsAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ContactSearchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactsAdapter(this, ContactsCache.contactListData, this)
    }

    // Recycler View Listener Methods
    override fun addContactChip(contact: Contact) {
        acTextView.append(contact.name)
        val chip = ChipDrawable.createFromResource(this, R.xml.chip_contact)
        val span = ImageSpan(chip)
        val cursorPosition: Int = acTextView.selectionStart
        val spanLength: Int = contact.name.length
        val text: Editable = acTextView.text
        //chip.chipIcon = ContextCompat.getDrawable(this@MainActivity, selectedContact.getAvatarResource())
        chip.text = contact.name
        chip.setBounds(0, 0, chip.intrinsicWidth, chip.intrinsicHeight)
        text.setSpan(
            span,
            cursorPosition - spanLength,
            cursorPosition,
            Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
    }

    override fun removeContactChip(contact: Contact) {

    }
}