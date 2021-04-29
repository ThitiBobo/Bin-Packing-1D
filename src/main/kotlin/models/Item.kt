package models

/**
 * The item class represents 1D size objects to store in the Bin
 * @param id: item's id
 * @param size: item's size in 1D
 */
class Item(private val id: Int, val size: Int) {

    /**
     * bin number in which the item is located
     */
    var binNumber : Int? = null

    override fun toString(): String {
        return "Item(binNumber=$binNumber, size=$size)"
    }
}