package utils

import models.BinPackingScenario
import models.operations.MoveOperation
import models.operations.Operation
import models.operations.SwitchOperation
import java.util.ArrayList
import kotlin.math.exp
import kotlin.random.Random

fun simulatedAnnealing(scenario: BinPackingScenario, tinit: Double, nmax: Int, kmax: Int, mu: Double){
    var i = 0
    var t = tinit
    for (n in 0..nmax){
        for (k in 1..kmax){
            var neighborhoods: List<Operation> = ArrayList()
            try {
                neighborhoods = scenario.getAllNeighborhoodOperation()
            } catch (e: Exception){
                println(e)
            }
            val neighborhood = neighborhoods[Random.nextInt(0, neighborhoods.size)]
            val delta = neighborhood.objectiveValue - scenario.objectiveValue

            if (delta >= 0){
                // TODO pas ouf, on peux implementer un pattern meilleur
                val bestObjectiveValue = scenario.bestObjectiveValue
                if (neighborhood is MoveOperation) { scenario.moveItem(neighborhood.item, neighborhood.bin) }
                if (neighborhood is SwitchOperation) { scenario.switchItem(neighborhood.item1, neighborhood.item2) }
                if (scenario.objectiveValue > bestObjectiveValue) {
                    scenario.updateBestScenario()
                }
            } else {
                val p = Math.random()
                if (p <= exp( -delta / t)){
                    if (neighborhood is MoveOperation) { scenario.moveItem(neighborhood.item, neighborhood.bin) }
                    if (neighborhood is SwitchOperation) { scenario.switchItem(neighborhood.item1, neighborhood.item2) }
                }
            }
            i++
        }
        t *= mu
    }
}