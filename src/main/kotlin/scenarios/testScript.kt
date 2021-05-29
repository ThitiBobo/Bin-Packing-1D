package scenarios

import models.Bin
import models.BinPackingScenario
import models.Item
import scenarios.base.ScriptBase
import utils.randomFirstFitGenerator
import utils.simulatedAnnealing


fun main(args: Array<String>) {

    // INITIALISATION
    println("[ test ]\n")
    val script = ScriptBase()
    val list = arrayListOf<String>(
        "4 10",
        "1",
        "2",
        "2",
        "3",
        "3",
        "1",
        "2",
        "3",
        "1",
        "1",
    )

    val binPackingScenario = BinPackingScenario("test",list);

    var itemList : List<Item> = ArrayList(binPackingScenario.itemList)
    binPackingScenario.initialize( ArrayList(randomFirstFitGenerator(itemList, binPackingScenario.binSizeLimit)) )

    display(binPackingScenario.originalBinList, binPackingScenario.originalObjectiveValue)
    simulatedAnnealing(binPackingScenario, 500.0, 10, 10, 0.95)
    display(binPackingScenario.bestBinList, binPackingScenario.bestObjectiveValue)
}
