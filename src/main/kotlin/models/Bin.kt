package models

import java.lang.Exception

class Bin(val sizeLimit: Int){

    var list: Array<Item> = arrayOf()

    fun getOccupiedSpace() = list.sumOf { it.size }
    fun getRemainingSpace() = sizeLimit - getOccupiedSpace()

    fun isFull() = (getRemainingSpace() == 0)
    fun isEmpty() = list.isEmpty()

    fun hasSpace(item: Item) = item.size <= getRemainingSpace()

    fun add(item: Item){
        if(!hasSpace(item))
            throw Exception("not enough space to put the item")
        list += item
    }

    override fun toString(): String {
        return "Bin(sizeLimit=$sizeLimit, list=${list.contentToString()})"
    }
}

