package io.syntaks.kotlinexpandablerecyclerview.data

data class Contact(val id: Int, val name: String, var selected: Boolean = false, var circleId: Int = 0) {
    companion object {
        // Dummy Data
        val contacts = mutableListOf(
            Contact(1, "Steve"),
            Contact(2, "John"),
            Contact(3, "Mary"),
            Contact(4, "Bill"),
            Contact(5, "Laura"),
            Contact(6, "Jacob"),
            Contact(7, "Max"),
            Contact(8, "Joe"),
            Contact(9, "Jayne"),
            Contact(10, "Peter"),
            Contact(11, "Kale"),
            Contact(12, "Megan"),
            Contact(13, "Tina"),
            Contact(14, "Thomas"),
            Contact(15, "Dane"),
            Contact(16, "Turner"),
            Contact(17, "Ike"),
            Contact(18, "Stanky Leg"),
            Contact(19, "Patrick"),
            Contact(20, "Tallulah")
        )

        fun setupDummyData(contactIds: List<Int>, circleId: Int): MutableList<Contact> {
            var results: MutableList<Contact> = ArrayList()
            for (contact in contacts) {
                if (contactIds.contains(contact.id)) {
                    contact.circleId = circleId
                    results.add(contact)
                }
            }
            return results
        }

        fun toggleSelection(contactIds: List<Int>) {

        }
    }
}