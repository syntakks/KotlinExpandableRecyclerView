package io.syntaks.kotlinexpandablerecyclerview.data

data class Contact(val name: String, val groups: List<Int>, var selected: Boolean) {
    companion object {
        val contacts = mutableListOf(
            Contact("Steve", listOf(1), false),
            Contact("John",listOf(1, 2), false),
            Contact("Mary",listOf(1, 3), false),
            Contact("Bill",listOf(1, 5), false),
            Contact("Laura",listOf(1, 2, 3, 4), false),
            Contact("Jacob",listOf(1, 5, 7, 8), false),
            Contact("Max",listOf(1, 2), false),
            Contact("Joe",listOf(1, 4, 5, 6), false),
            Contact("Jayne",listOf(1, 8, 9, 10), false),
            Contact("Peter",listOf(1, 5, 6), false),
            Contact("Kale",listOf(1, 4, 6), false),
            Contact("Megan",listOf(1, 6, 9), false),
            Contact("Tina",listOf(1, 10, 11), false),
            Contact("Thomas",listOf(1, 11), false),
            Contact("Dane",listOf(1, 15), false),
            Contact("Turner",listOf(1, 8), false),
            Contact("Ike",listOf(1, 3, 4), false),
            Contact("Stanky Leg",listOf(1, 9, 10), false),
            Contact("Patrick",listOf(1, 12, 13, 14), false),
            Contact("Tallulah",listOf(1, 11, 12, 13, 14, 15), false)
        )
    }
}