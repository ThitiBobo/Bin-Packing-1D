package scenarios

import models.Bin
import models.BinPackingScenario
import models.Item
import scenarios.base.ScriptBase
import utils.oneItemPerBinGenerator
import utils.randomFirstFitGenerator
import utils.simulatedAnnealing

const val T_INIT: Double = 500.0
const val N_MAX: Int = 10
const val K_MAX: Int = 10
const val MU: Double = 0.95


fun main() {
    // INITIALISATION
    println("[ Script 5 ]\n")
    val script = ScriptBase()
    val list = script.scenarioManager.scenarioList

    var scenario = list[0]

    var itemList : List<Item> = ArrayList(scenario.itemList)
    scenario.initialize( ArrayList(oneItemPerBinGenerator(itemList, scenario.binSizeLimit)) )

    display(scenario.originalBinList, scenario.originalObjectiveValue)
    simulatedAnnealing(scenario, T_INIT, N_MAX, K_MAX, MU)
    display(scenario.bestBinList, scenario.bestObjectiveValue)

//    list.forEach { scenario ->
//        var itemList : List<Item> = ArrayList(scenario.itemList)
//        scenario.initialize( ArrayList(randomFirstFitGenerator(itemList, scenario.binSizeLimit)) )
//
//        display(scenario.originalBinList, scenario.originalObjectiveValue)
//        simulatedAnnealing(scenario, T_INIT, N_MAX, K_MAX, MU)
//        display(scenario.bestBinList, scenario.bestObjectiveValue)
//    }

}

fun display(binList: List<Bin>, objectiveValue: Double){
    binList.forEach { bin ->
        print("[ ")
        bin.list.forEach {
            print("${it.size} ")
        }
        println("] : ${bin.getOccupiedSpace()}   :   ${bin.objectiveValue}")
    }
    println()
    println("$objectiveValue : ${binList.size}")
    println()
}