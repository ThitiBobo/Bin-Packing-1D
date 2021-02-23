package model

class BinPackingScenario {

    var binSizeLimit = 0
    var itemList : Array<Item> = arrayOf();

    fun instantiate(binSizeLimit: Int, itemList: List<Int>) {
        this.binSizeLimit = binSizeLimit
        itemList.forEachIndexed { index, element -> this.itemList += Item(index, element) }
    }

    fun instantiate(itemList: List<String>) {
        val header: String = itemList[0].toString()
        this.binSizeLimit = header.split(' ')[0].toInt();
        itemList.drop(1).forEachIndexed { index, element -> this.itemList += Item(index, element.toInt()) }
    }

    private fun getSumItemSize(): Int = itemList.sumBy { it.size }

    fun getTheoreticalMinimumBinNumber(): Int = getSumItemSize() / binSizeLimit
}
