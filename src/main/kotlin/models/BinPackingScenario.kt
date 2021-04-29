package models

class BinPackingScenario {

    var scenarioName: String = "unknown"
    var binSizeLimit = 0
    var itemList : Array<Item> = arrayOf();

    var x: Int = 4
        get() = field
        set(value){
            field = value
        }

    var binList: ArrayList<Bin> = ArrayList()
        set(value){
            field = value
            field.forEachIndexed{ index, bin ->
                bin.list.forEach { item ->
                    item.binNumber = index
                }
                bin.updateObjectiveValue()
            }
        }

    fun initialize(name: String, itemList: List<String>) {
        scenarioName = name
        val header: String = itemList[0].toString()
        this.binSizeLimit = header.split(' ')[0].toInt();
        itemList.drop(1).forEachIndexed { index, element -> this.itemList += Item(index, element.toInt()) }
    }

    fun getSumItemSize(): Int = itemList.sumBy { it.size }

    fun switchItem(item1: Int, item2: Int) {

    }

    fun moveItem(item: Int, newBin: Int) {
        itemList[item].binNumber

        if (newBin >= binList.size)
            binList.add(Bin(binSizeLimit))

    }

    override fun toString(): String {
        return "BinPackingScenario(scenarioName='$scenarioName', binSizeLimit=$binSizeLimit, " +
                "itemList=${itemList.contentToString()}, binList=${binList.toString()})"
    }


}
