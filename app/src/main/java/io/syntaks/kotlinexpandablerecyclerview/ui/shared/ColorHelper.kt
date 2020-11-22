package io.syntaks.kotlinexpandablerecyclerview.ui.shared

import android.content.res.ColorStateList

class ColorHelper {
    companion object {
        fun stateListForColorResource(colorResource: Int): ColorStateList {
            return ColorStateList.valueOf(colorResource)
        }
    }
}

