package models

/**
 * The item class represents 1D size objects to store in the Bin
 * @param index: item's index
 * @param size: item's size in 1D
 */
class Item(private val index: Int, val size: Int) {

    override fun toString(): String {
        return "Item(index=$index, size=$size)"
    }
}