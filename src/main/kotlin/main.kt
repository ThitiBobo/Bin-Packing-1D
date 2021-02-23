import model.BinPackingScenario
import utils.fileReader

fun main(args: Array<String>) {
    println("Hello World!")

    var k = fileReader("ressources/data/binpack1d_00.txt")
    val scenario = BinPackingScenario();
    scenario.instantiate(k)
    println("size : ${scenario.binSizeLimit}")
    println("elements: ${scenario.itemList}")

    println(scenario.getTheoreticalMinimumBinNumber())

}