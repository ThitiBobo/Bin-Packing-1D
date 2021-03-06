package models

import java.lang.Exception
import kotlin.math.pow

class Bin(val sizeLimit: Int){

    var objectiveValue: Double = 0.0

    var list: ArrayList<Item> = ArrayList()

    fun getOccupiedSpace() = list.sumOf { it.size }
    private fun getRemainingSpace() = sizeLimit - getOccupiedSpace()

    fun isFull() = (getRemainingSpace() == 0)
    fun isEmpty() = list.isEmpty()

    fun hasSpace(item: Item) = item.size <= getRemainingSpace()

    fun add(item: Item){
        if(!hasSpace(item))
            throw Exception("not enough space to put the item, ${this.sizeLimit} : ${this.getRemainingSpace()} : ${item.size}")
        list.add(item)
    }

    override fun toString(): String {
        return "Bin(sizeLimit=$sizeLimit, list=${list.toArray().contentToString()})"
    }

    fun updateObjectiveValue(): Double {
        var value = list.map { it.size }.sum().toDouble()
        objectiveValue = value.pow(2.0)
        return objectiveValue
    }

    fun clone(): Bin {
        var bin = Bin(this.sizeLimit)
        bin.objectiveValue = this.objectiveValue
        this.list.forEach{
            var item = it.clone()
            bin.add(item)
            item.bin = bin
        }
        return bin
    }
}

