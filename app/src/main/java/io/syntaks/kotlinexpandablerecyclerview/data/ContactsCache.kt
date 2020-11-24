package io.syntaks.kotlinexpandablerecyclerview.data

object ContactsCache {
    var circles = mutableListOf<Circle>()
    var contacts = mutableListOf<Contact>()
    var contactListData = mutableListOf<Any>()

    init {
        circles = Circle.circles
        contacts = Contact.contacts
        contactListData = circles.map { it.copy() }.toMutableList()
    }

    fun getCircleById(circleId: Int): Circle? {
        return circles.find { circle -> circle.id == circleId }
    }

}