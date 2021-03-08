package scenarios

import interfaces.ExecutableScript
import models.Bin
import models.BinPackingScenario
import utils.oneItemPerBinGenerator

class Script4: ExecutableScript<BinPackingScenario> {
    override fun execute(list: Array<BinPackingScenario>) {

        // INITIALISATION
        val answers:ArrayList<List<Bin>> = arrayListOf()

        // OPERATION
        list.forEach {
            answers.add(oneItemPerBinGenerator(it.itemList, it.binSizeLimit))
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
}