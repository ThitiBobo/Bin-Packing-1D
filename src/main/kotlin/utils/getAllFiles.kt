package utils

import java.io.File

fun getAllFiles(path: String) = File(path).listFiles().toList()