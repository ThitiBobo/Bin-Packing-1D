import models.ScenarioManager

import utils.firstFitDecreasing
import utils.randomFirstFitGenerator

const val FOLDER_PATH = "resources/data/"

fun main(args: Array<String>) {
    println("[  START  ]")
    println()

    val scenarioManager = ScenarioManager()
    scenarioManager.folderPath = FOLDER_PATH
    scenarioManager.initialize()


    var scenario = scenarioManager.scenarioList[0];
    scenario.binList = ArrayList(randomFirstFitGenerator(scenario.itemList,scenario.binSizeLimit))

    var binList = scenario.binList
    binList.forEach { bin ->
        print("[ ")
        bin.list.forEach {
            print("${it.size} ")
        }
        println("] : ${bin.getOccupiedSpace()}   :   ${bin.objectiveValue}")
    }
    println()

    scenario.itemList.forEach { item ->
        println(item)
    }

}