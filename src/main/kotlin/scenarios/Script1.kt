package scenarios

import interfaces.ExecutableScript
import models.BinPackingScenario

class Script1: ExecutableScript<BinPackingScenario> {

    override fun execute(list: Array<BinPackingScenario>) {
        println("--- Script 1 ---")

        list.forEach { println(it.getTheoreticalMinimumBinNumber()) }
    }
}