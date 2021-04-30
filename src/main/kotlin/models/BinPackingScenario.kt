package models

import exceptions.OverloadedBinException
import models.operations.MoveOperation
import models.operations.Operation
import models.operations.SwitchOperation
import org.apache.commons.math3.exception.OutOfRangeException
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class BinPackingScenario(scenarioName: String, itemList: List<String>) {

    var objectiveValue: Double = 0.0

    var scenarioName: String = "unknown"
    var binSizeLimit = 0
    val itemList : ArrayList<Item> = ArrayList()

    var binList: ArrayList<Bin> = ArrayList()
        private set
    var originalBinList: List<Bin> = ArrayList()
        private set
    var bestBinList: List<Bin> = ArrayList()
        private set

    var operationHistory: LinkedList<Operation> = LinkedList()

    init {
        this.scenarioName = scenarioName
        val header: String = itemList[0].toString()
        this.binSizeLimit = header.split(' ')[0].toInt();
        itemList.drop(1).forEachIndexed { index, element -> this.itemList += Item(index, element.toInt()) }
    }

    fun initialize(binList: ArrayList<Bin>){

        binList.forEach { bin ->
            bin.list.forEach { item ->
                item.bin = bin
            }
            bin.updateObjectiveValue()
        }
        this.objectiveValue = this.originalBinList.map { it.objectiveValue }.sum()

        this.binList = binList
        this.originalBinList = ArrayList(binList)
        this.bestBinList = ArrayList(binList)

        updateObjectiveValue()
    }

    fun getSumItemSize(): Int = itemList.sumBy { it.size }

    fun switchItem(item1: Int, item2: Int){
        if (item1 < 0 || item1 >= itemList.size){
            throw OutOfRangeException(item1,0,itemList.size)
        }
        val item1Object = itemList[item1]

        if (item2 < 0 || item2 >= itemList.size){
            throw OutOfRangeException(item2,0,itemList.size)
        }
        val item2Object = itemList[item2]

        switchItem(item1Object, item2Object)
    }

    fun switchItem(item1: Item, item2: Item) {
        if (item1.bin == null || item2.bin == null){
            throw Exception("items must be in bin ")
        }
        // REMOVE ITEMS
        item1.bin!!.list.remove(item1)
        item2.bin!!.list.remove(item2)
        // CHECK SPACE
        try {
            if (!item1.bin!!.hasSpace(item2)) throw OverloadedBinException(item1, item2.bin!!)
            if (!item2.bin!!.hasSpace(item1)) throw OverloadedBinException(item2, item1.bin!!)
        }catch (exception: OverloadedBinException){
            // PUTS ITEMS BACK
            item1.bin!!.list.add(item1)
            item2.bin!!.list.add(item2)
            throw exception
        }
        // MOVE ITEMS
        item1.bin!!.list.add(item2)
        item2.bin!!.list.add(item1)
        // UPDATE ITEM'S BIN
        val bin1 = item2.bin
        item1.bin = item2.bin
        item2.bin = bin1
        // UPDATE OBJECTIVE VALUE
        item1.bin!!.updateObjectiveValue()
        item2.bin!!.updateObjectiveValue()
        updateObjectiveValue()

        this.operationHistory.add(SwitchOperation(item1,item2))
    }

    fun moveItem(item: Int, newBin: Int){
        if (item < 0 || item >= itemList.size){
            throw OutOfRangeException(item,0,itemList.size)
        }
        val itemObject = itemList[item]

        var binObject: Bin
        if (newBin < 0 || newBin >= binList.size) {
            binObject = Bin(binSizeLimit)
            binList.add(binObject)
        }else{
            binObject = binList[newBin]
        }
        moveItem(itemObject, binObject)
    }

    fun moveItem(item: Item, newBin: Bin) {
        if (!newBin.hasSpace(item)) {
            throw OverloadedBinException(item, newBin)
        }

        val oldBin = item.bin

        // MOVE ITEM
        oldBin?.list?.remove(item)
        newBin.list.add(item)
        item.bin = newBin

        // IF OLD BIN EMPTY
        if (oldBin?.isEmpty() == true){
            binList.remove(oldBin)
        }

        // UPDATE OBJECTIVE VALUE
        newBin.updateObjectiveValue()
        oldBin?.updateObjectiveValue()
        updateObjectiveValue()

        this.operationHistory.add(MoveOperation(item,newBin))
    }

    fun updateObjectiveValue(){
        this.objectiveValue = this.binList.map { it.objectiveValue }.sum()
    }

    override fun toString(): String {
        return "BinPackingScenario(scenarioName='$scenarioName', binSizeLimit=$binSizeLimit, " +
                "itemList=${itemList.toArray().contentToString()}, binList=${originalBinList.toString()})"
    }


}
