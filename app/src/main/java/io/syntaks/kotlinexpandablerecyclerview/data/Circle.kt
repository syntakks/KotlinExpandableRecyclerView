package io.syntaks.kotlinexpandablerecyclerview.data

data class Circle(val name: String, var expanded: Boolean) {
    companion object {
        val circles = mutableListOf(
            Circle("Buddies", false),
            Circle("Friends", false),
            Circle("Pals", false),
            Circle("Buds", false),
            Circle("Compatriot", false),
            Circle("Enemies", false),
            Circle("Lovers", false),
            Circle("Who Dis?", false),
            Circle("Dummies", false),
            Circle("FWB", false),
            Circle("Mom?", false),
            Circle("Billys Friends", false),
            Circle("Dirty Mike and the boys", false),
            Circle("Prospects", false),
            Circle("Missed Connections", false)
        )
    }
}