package scenarios.base

import models.ScenarioManager

const val FOLDER_PATH = "resources/data/"

class ScriptBase {

    var scenarioManager: ScenarioManager = ScenarioManager()

    init {
        scenarioManager.folderPath = FOLDER_PATH
        scenarioManager.initialize()
    }
}