package models

class BinPackingScenario {

    var scenarioName: String = "unknown"
    var binSizeLimit = 0
    var itemList : Array<Item> = arrayOf();


    fun initialize(name: String, itemList: List<String>) {
        scenarioName = name
        val header: String = itemList[0].toString()
        this.binSizeLimit = header.split(' ')[0].toInt();
        itemList.drop(1).forEachIndexed { index, element -> this.itemList += Item(index, element.toInt()) }
    }

    fun getSumItemSize(): Int = itemList.sumBy { it.size }


    override fun toString(): String {
        return "BinPackingScenario(scenarioName='$scenarioName', binSizeLimit=$binSizeLimit, itemList=${itemList.contentToString()})"
    }


}
