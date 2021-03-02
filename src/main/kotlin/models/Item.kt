package models

class Item(var index: Int, var size: Int) {

    override fun toString(): String {
        return "Item(index=$index, size=$size)"
    }
}