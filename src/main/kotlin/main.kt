import models.ScenarioManager
import scenarios.Script1
import scenarios.Script2
import scenarios.Script4
import utils.firstFitDecreasing

const val FOLDER_PATH = "resources/data/"

fun main(args: Array<String>) {
    println("[  START   ]")
    println()

    val scenarioManager = ScenarioManager()
    scenarioManager.folderPath = FOLDER_PATH
    scenarioManager.initialize()

    scenarioManager.execute(Script1())
    // scenarioManager.execute(Script2())
    // scenarioManager.execute(Script3())
    scenarioManager.execute(Script4())
}