package io.syntaks.kotlinexpandablerecyclerview.data

data class Circle(
    val id: Int,
    val name: String,
    var contacts: MutableList<Contact>,
    var selected: Boolean = false,
    var expanded: Boolean = false
) {
    companion object {
        //Dummy Data
        val circles = mutableListOf(
            Circle(1, "Buddies", Contact.setupDummyData(mutableListOf(1, 2, 3, 4), 1)),
            Circle(2, "Friends", Contact.setupDummyData(mutableListOf(5, 6, 7, 8), 2)),
            Circle(3, "Pals", Contact.setupDummyData(mutableListOf(9, 10, 11, 12), 3)),
            Circle(4, "Buds", Contact.setupDummyData(mutableListOf(13, 14, 15), 4)),
            Circle(5, "Compatriot", Contact.setupDummyData(mutableListOf(1, 3, 5, 7, 9), 5)),
            Circle(6, "Enemies", Contact.setupDummyData(mutableListOf(2, 4, 6, 8, 10), 6)),
            Circle(7, "Lovers", Contact.setupDummyData(mutableListOf(3, 6, 9, 12), 7)),
            Circle(8, "Who Dis?", Contact.setupDummyData(mutableListOf(4, 8, 12), 8)),
            Circle(9, "Dummies", Contact.setupDummyData(mutableListOf(5, 10, 15), 9)),
            Circle(10, "FWB", Contact.setupDummyData(mutableListOf(1, 4, 5), 10)),
            Circle(11, "Mom?", Contact.setupDummyData(mutableListOf(3, 6, 7), 11)),
            Circle(12, "Billy's Friends", Contact.setupDummyData(mutableListOf(6, 7, 8, 9), 12)),
            Circle(13, "Dirty Mike and the boys", Contact.setupDummyData(mutableListOf(10, 11, 12, 13, 14, 15), 13)),
            Circle(14, "Prospects", Contact.setupDummyData(mutableListOf(7, 8, 9, 10, 11, 12), 14)),
            Circle(15, "Prospects", Contact.setupDummyData(mutableListOf(7, 8, 9, 10, 11, 15), 15)),
        )
    }

    fun toggleCircleSelection() {
        selected = !selected
        for (contact in contacts) {
            contact.selected = selected
        }
    }

    fun isCircleSelected(): Boolean {
        for (contact in contacts) {
            if (!contact.selected) {
                return false
            }
        }
        return true
    }
}

