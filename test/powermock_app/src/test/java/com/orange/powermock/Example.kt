package com.orange.powermock

import java.io.File

class Example {
    fun instance(file: File): Boolean {
        return file.exists()
    }
}