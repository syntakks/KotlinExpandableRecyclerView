package io.syntaks.kotlinexpandablerecyclerview.data

class ContactsCache {
    var circles = mutableListOf<Circle>()
    var contacts = mutableListOf<Contact>()
    var flatMap = mutableListOf<Any>()

    init {
        circles = Circle.circles
        contacts = Contact.contacts
        for (circle in circles) {
            flatMap.add(circle)
            for (contact in circle.contacts) {
                flatMap.add(contact.copy())
            }
        }
    }

    fun getCircleById(circleId: Int): Circle? {
        return circles.find { circle -> circle.id == circleId }
    }

}