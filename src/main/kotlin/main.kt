import exceptions.OverloadedBinException
import models.BinPackingScenario
import models.Item
import models.ScenarioManager
import utils.combination

import utils.randomFirstFitGenerator

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
    try {
        scenario.switchItem(3,7)
    }catch (e: OverloadedBinException){
        println(scenario.itemList[3].bin)
        println(scenario.itemList[4].bin)
    }
    display(scenario)

    var tt = scenario.getAllNeighborhoodOperation()
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
    println("${scenario.objectiveValue} : ${scenario.originalBinList.size}")
    println()
}