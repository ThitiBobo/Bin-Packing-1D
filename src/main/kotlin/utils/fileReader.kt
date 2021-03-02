package utils

import java.io.File

fun fileReader(fileName: String): List<String> = File(fileName).useLines { it.toList() }