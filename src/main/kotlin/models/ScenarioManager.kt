package models

import utils.fileReader
import utils.getAllFiles
import java.lang.Exception

class ScenarioManager {

    var scenarioList: Array<BinPackingScenario> = arrayOf()
    var folderPath: String? = null

    fun initialize(){
        if (folderPath == null)
            throw Exception("folderPath can't be undefined, null")
        val list = getAllFiles(folderPath!!).sorted()

        list.forEach {
            val file = fileReader(it.toString())
            var scenario = BinPackingScenario(it.toString(), file)
            this.scenarioList += scenario
        }
    }
}
