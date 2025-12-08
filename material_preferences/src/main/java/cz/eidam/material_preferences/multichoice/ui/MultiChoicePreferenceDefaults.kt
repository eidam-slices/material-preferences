package cz.eidam.material_preferences.multichoice.ui

import kotlin.collections.take

object MultiChoicePreferenceDefaults {

//    val remainingItemsSize = this.size - maxDisplayItems
//    val displayedItems = this.take(maxDisplayItems)
//
//    return if (remainingItemsSize > 0) {
//        val remainingItem = "+$remainingItemsSize"
//        displayedItems.plus(remainingItem)
//    } else {
//        displayedItems
//    }.joinToString(", ")

    const val MAX_ITEMS_DISPLAYED = 1

    fun formatter(): (List<String>) -> String = { selected ->
        val remainingItemsSize = selected.size - MAX_ITEMS_DISPLAYED
        val displayedItems = selected.take(MAX_ITEMS_DISPLAYED)

        if (remainingItemsSize > 0) {
            val remainingText = "+$remainingItemsSize"
            displayedItems.plus(remainingText)
        } else {
            displayedItems
        }.joinToString(", ")
    }
}