package scenarios

import models.Bin
import models.BinPackingScenario
import scenarios.base.ScriptBase
import utils.firstFitDecreasing

fun main(args: Array<String>) {

    // INITIALISATION
    println("[ Script 2 ]\n")
    val script = ScriptBase()
    val list = script.scenarioManager.scenarioList
    val answers: ArrayList<List<Bin>> = arrayListOf()
    var timeAnswers: Array<Long> = arrayOf()

    // OPERATION
    val start = System.currentTimeMillis()
    list.forEach {
        val start2 = System.currentTimeMillis()
        answers.add(firstFitDecreasing(it.itemList, it.binSizeLimit))
        timeAnswers += System.currentTimeMillis() - start2
    }
    val time = System.currentTimeMillis() - start

    // DISPLAY
    println("execution time : $time ms")
    answers.forEachIndexed { index, binList ->
        println("time: ${timeAnswers[index]} ms  size max: ${binList.first().sizeLimit}  bins: ${binList.size}")
        /*
    binList.forEach { bin ->
        print("[ ")
        bin.list.forEach {
            print("${it.size} ")
        }
        println("] : ${bin.getOccupiedSpace()}")
    }
    println()
    */
    }
    println("\n")
}