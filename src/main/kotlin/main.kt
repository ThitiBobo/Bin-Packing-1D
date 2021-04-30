import exceptions.OverloadedBinException
import models.BinPackingScenario
import models.Item
import models.ScenarioManager
import utils.combination

import utils.randomFirstFitGenerator
import utils.simulatedAnnealing

const val FOLDER_PATH = "resources/data/"

fun main(args: Array<String>) {
    println("[  START  ]")
    println()

    val scenarioManager = ScenarioManager()
    scenarioManager.folderPath = FOLDER_PATH
    scenarioManager.initialize()


    var scenario = scenarioManager.scenarioList[0];
    var list : List<Item> = ArrayList(scenario.itemList)
    scenario.initialize(ArrayList(randomFirstFitGenerator(list, scenario.binSizeLimit)))

    scenario.itemList.forEach { item ->
        print(" ${item.size}")
    }
    println()
    display(scenario)

    simulatedAnnealing(scenario, 500.0, 100, 200, 0.90)
    display(scenario)
}


fun display(scenario: BinPackingScenario){
    var binList = scenario.binList
    binList.forEach { bin ->
        print("[ ")
        bin.list.forEach {
            print("${it.size} ")
        }
        println("] : ${bin.getOccupiedSpace()}   :   ${bin.objectiveValue}")
    }
    println()
    println("${scenario.objectiveValue} : ${scenario.binList.size}")
    println()
}