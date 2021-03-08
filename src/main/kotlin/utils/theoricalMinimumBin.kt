package utils

import kotlin.math.ceil

fun getTheoreticalMinimumBinNumber(sumItemSize: Int, binSizeLimit: Int): Int {
    val res: Float = sumItemSize.toFloat() / binSizeLimit.toFloat()
    return ceil(res).toInt()
}

@Deprecated("user the getTheoreticalMinimumBinNumber() method", ReplaceWith("sumItemSize / binSizeLimit"))
fun getWrongTheoreticalMinimumBinNumber(sumItemSize: Int, binSizeLimit: Int) = sumItemSize / binSizeLimit