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
}
