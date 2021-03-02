import models.ScenarioManager
import scenarios.Script1

fun main(args: Array<String>) {
    println("--- Start ---")

    val scenarioManager = ScenarioManager()
    scenarioManager.folderPath = "ressources/data/"
    scenarioManager.initialize()

    scenarioManager.execute(Script1())
}