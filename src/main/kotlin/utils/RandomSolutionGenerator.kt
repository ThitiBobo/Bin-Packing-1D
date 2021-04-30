package utils

import models.Bin
import models.Item

fun oneItemPerBinGenerator(items: List<Item>, binSizeLimit: Int): List<Bin> {

    val binList :MutableList<Bin> = mutableListOf()
    var array = ArrayList(items)
    array.shuffle()

    array.forEach {
        binList.add(Bin(binSizeLimit))
        binList.last().add(it)
    }

    return binList.toList()
}

fun randomFirstFitGenerator(items: List<Item>, binSizeLimit: Int): List<Bin> {
    var array = ArrayList(items)
    array.shuffle()
    return firstFitDecreasingBase(array, binSizeLimit)
}