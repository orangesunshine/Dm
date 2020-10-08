package com.orange.databinding

import org.junit.Test

class ExampleUnitTest {
    fun String.lastChar(): Char {
        return this?.get(this.length - 1)
    }
    @Test
    fun extendFun(){
        JoinString().joinToString(collection = ArrayList<String>(), separator = "666")
        println("younger".lastChar())
    }

    @Test
    fun range(){
        val oneToNine = 1 until 10
        for(i in oneToNine){
            println("i: ${i}")
        }
    }

    @Test
    fun indices(){
        val arrayList = ArrayList<String>()
        arrayList.add("a")
        arrayList.add("b")
        arrayList.add("c")
        arrayList.add("d")
        for(i in arrayList.indices){
            println("i: ${i}, arraylist.get(i): ${arrayList.get(i)}")
        }

        val x = 1
        var b = when(x){
            0,1 -> x+1
            else -> 0
        }

    }
}