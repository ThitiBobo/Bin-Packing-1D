package scenarios

import interfaces.ExecutableScript
import models.BinPackingScenario
import utils.getTheoreticalMinimumBinNumber
import utils.getWrongTheoreticalMinimumBinNumber

class Script1: ExecutableScript<BinPackingScenario> {

    override fun execute(list: Array<BinPackingScenario>) {

        // INITIALISATION
        println("[ Script 1 ]\n")
        val answers:ArrayList<Int> = arrayListOf()

        // OPERATION
        val start = System.currentTimeMillis()
        list.forEach {
            answers.add(getTheoreticalMinimumBinNumber(it.getSumItemSize(), it.binSizeLimit))
        }
        val time = System.currentTimeMillis() - start

        // DISPLAY
        println("execution time : $time ms")
        answers.forEach { print("$it, ") }
        println("\n")



        // WRONG

        val answers2:ArrayList<Int> = arrayListOf()
        val start2 = System.currentTimeMillis()
        list.forEach {
            answers2.add(getWrongTheoreticalMinimumBinNumber(it.getSumItemSize(), it.binSizeLimit))
        }
        val time2 = System.currentTimeMillis() - start2

        println("Wrong method : Remove this part")
        println("execution time : $time2 ms")
        answers2.forEach { print("$it, ") }
        println("\n")
    }
}