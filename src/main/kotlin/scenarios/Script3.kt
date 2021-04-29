package scenarios

import models.BinPackingScenario
import scenarios.base.ScriptBase

fun main(args: Array<String>) {

    // INITIALISATION
    println("[ Script 3 ]\n")
    val script = ScriptBase()
    val list = script.scenarioManager.scenarioList
    // val answers:ArrayList<List<Bin>> = arrayListOf()
    var timeAnswers: Array<Long> = arrayOf()

    // OPERATION
    val start = System.currentTimeMillis()
    list.forEach {
        val start2 = System.currentTimeMillis()


        timeAnswers += System.currentTimeMillis() - start2
    }
    val time = System.currentTimeMillis() - start
}