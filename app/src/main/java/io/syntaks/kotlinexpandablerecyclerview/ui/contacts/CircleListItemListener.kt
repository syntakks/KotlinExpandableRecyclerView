package io.syntaks.kotlinexpandablerecyclerview.ui.contacts

import io.syntaks.kotlinexpandablerecyclerview.data.Circle

interface CircleListItemListener {
    fun toggleCircleExpanded(position: Int)
    fun toggleCircleSelection(position: Int)
}