package utils

import models.Bin
import models.Item

fun combination(list: List<Item>): List<Pair<Item,Item>>{
    var combinations: ArrayList<Pair<Item,Item>> = ArrayList()
    for (i in 0 until list.size){
        for (j in (i+1) until list.size)
            combinations.add(Pair(list[i], list[j]))
    }
    return combinations
}

fun combination(itemList: List<Item>, binList: List<Bin>): List<Pair<Item,Bin>> {
    var combination: ArrayList<Pair<Item,Bin>> = ArrayList()
    for (item in itemList){
        for (bin in binList){
            combination.add(Pair(item,bin))
        }
    }
    return combination
}