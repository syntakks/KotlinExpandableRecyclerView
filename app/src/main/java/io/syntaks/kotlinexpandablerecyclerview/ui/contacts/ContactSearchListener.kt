package io.syntaks.kotlinexpandablerecyclerview.ui.contacts

import io.syntaks.kotlinexpandablerecyclerview.data.Contact

interface ContactSearchListener {
    fun addContactChip(contact: Contact)
    fun removeContactChip(contact: Contact)
}