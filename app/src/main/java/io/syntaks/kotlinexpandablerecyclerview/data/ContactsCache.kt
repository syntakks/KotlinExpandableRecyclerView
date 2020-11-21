package io.syntaks.kotlinexpandablerecyclerview.data

class ContactsCache {
    var circles = mutableListOf<Circle>()
    var contacts = mutableListOf<Contact>()
    init {
        circles = Circle.circles
        contacts = Contact.contacts
    }
    fun getContactsForCircle(circle: Int): List<Contact> {
        val results: MutableList<Contact> = ArrayList()
        for (contact in contacts) {
            if (contact.groups.contains(circle)) {
                results.add(contact)
            }
        }
        return results
    }
}