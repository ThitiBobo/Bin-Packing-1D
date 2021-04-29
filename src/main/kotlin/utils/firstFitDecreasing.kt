package utils

import models.Bin
import models.Item

fun firstFitDecreasingBase(items: Array<Item>, binSizeLimit: Int): List<Bin> {

    val binList: MutableList<Bin> = mutableListOf()
    val notFullListBin: MutableList<Bin> = mutableListOf()

    notFullListBin.add(Bin(binSizeLimit))

    items.forEach loop@{item ->
        var packed = false
        notFullListBin.forEachIndexed{ index, bin ->
            if(bin.hasSpace(item)){
                bin.add(item)
                packed = true
                if (bin.isFull()) {
                    binList.add(notFullListBin.removeAt(index))
                }
                return@loop
            }
        }
        if (!packed){
            val bin = Bin(binSizeLimit)
            bin.add(item)
            notFullListBin.add(bin)
        }
    }
    notFullListBin.forEach{
        binList.add(it)
    }

    return binList.toList()
}

fun firstFitDecreasing(items: Array<Item>, binSizeLimit: Int): List<Bin> {
    val itemsList = items.sortedByDescending { it.size }
    return firstFitDecreasingBase(itemsList.toTypedArray(), binSizeLimit)
}