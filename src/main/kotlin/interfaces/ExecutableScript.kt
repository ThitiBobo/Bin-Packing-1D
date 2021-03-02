package interfaces

import models.BinPackingScenario

interface ExecutableScript<T> {
    fun execute(list: Array<BinPackingScenario>)
}