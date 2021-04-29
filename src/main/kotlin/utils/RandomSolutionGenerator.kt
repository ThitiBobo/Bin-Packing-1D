package utils

import models.Bin
import models.Item

fun oneItemPerBinGenerator(items: Array<Item>, binSizeLimit: Int): List<Bin> {

    val binList :MutableList<Bin> = mutableListOf()
    items.shuffle()

    items.forEach {
        binList.add(Bin(binSizeLimit))
        binList.last().add(it)
    }

    return binList.toList()
}

fun randomFirstFitGenerator(items: Array<Item>, binSizeLimit: Int): List<Bin> {
    items.shuffle()
    return firstFitDecreasingBase(items, binSizeLimit)
}