package com.orange.mvvm.test.entrypoint

import android.content.Context

class EntryPoint(context: Context) {
    val dog: Dog = Dog(context)

    fun getWork(): Work {
        return dog.work
    }
}