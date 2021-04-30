package scenarios

import models.Bin
import models.BinPackingScenario
import models.Item
import scenarios.base.ScriptBase
import utils.randomFirstFitGenerator

fun main(args: Array<String>) {

    // INITIALISATION
    println("[ Script 4 ]\n")
    val script = ScriptBase()
    val list = script.scenarioManager.scenarioList
    val answers:ArrayList<List<Bin>> = arrayListOf()

    // OPERATION
    list.forEach {
        answers.add(randomFirstFitGenerator(it.itemList, it.binSizeLimit))
    }

    // DISPLAY
    answers.forEachIndexed { index, binList ->
        println("size max: ${binList.first().sizeLimit}  bins: ${binList.size}")
        binList.forEach { bin ->
            print("[ ")
            bin.list.forEach {
                print("${it.size} ")
            }
            println("] : ${bin.getOccupiedSpace()}")
        }
        println()
    }
    println("\n")
}