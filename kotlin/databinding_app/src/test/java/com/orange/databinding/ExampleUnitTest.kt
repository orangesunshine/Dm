package com.orange.databinding

import org.junit.Test
import java.util.function.Function

class ExampleUnitTest {
    fun String.lastChar(): Char {
        return this?.get(this.length - 1)
    }

    @Test
    fun extendFun() {
        JoinString().joinToString(collection = ArrayList<String>(), separator = "666")
        println("younger".lastChar())
    }

    @Test
    fun range() {
        val f1 = Function<String, String> { s -> s + "younger" }
        val fun1 = { s: String -> s + "orange" }
        val min: (String) -> String = { s -> s + "min" }
        val f2 = Function<String, String>(min)

        val languages = listOf("Java", "Kotlin", "Python", "JavaScript")
        languages.filter {
            it.contains("Java")
        }.forEach { s: String -> println() }

        val oneToNine = 1 until 10
        for (i in oneToNine) {
            println("i: ${i}")
        }
    }

    @Test
    fun indices() {
        val arrayList = ArrayList<String>()
        arrayList.add("a")
        arrayList.add("b")
        arrayList.add("c")
        arrayList.add("d")
        for (i in arrayList.indices) {
            println("i: ${i}, arraylist.get(i): ${arrayList.get(i)}")
        }

        val x = 1
        var b = when (x) {
            0, 1 -> x + 1
            else -> 0
        }
    }

    @Test
    fun lambdalimit() {
        val array = listOf("Java", "Kotlin")
        val stringBuffer = StringBuffer()
        val buffer = with(stringBuffer, {
            array.forEach {
                if (it.equals("Java")) {
                    return@with it
                }
            }
        })
        println(stringBuffer.toString())
        println(buffer == stringBuffer)

        var buff = stringBuffer.apply {
            array.forEach {
                if (it.equals("Java")) {
                    return@apply println(it)
                }
            }
        }

        println(buff.javaClass.canonicalName)
    }

    @Test
    fun returnTest() {
        val array = listOf("Java", "Kotlin")
        array.forEach(System.out::println)
    }

    @Test
    fun sam() {
        //显示sam
        val interfaceObject = daqiInterface {
            //返回String类型值
            "daqi"
        }
        daqiJava().setDaqiInterface(interfaceObject)
        //隐示sam
        daqiJava().setDaqiInterface { "sam" }
    }


    @Test
    fun sequence() {
        val sequenceOf = sequenceOf(1, 2, 3, 4)
        val asSequence = listOf(1, 2, 3, 4).asSequence()
        val generateSequence = generateSequence(6) { if (it < 10) it + 2 else null }
        sequence {
            yield(1)
            yieldAll(listOf(1, 2, 3))
            yieldAll(setOf(1, 2, 3))
        }

        //惰性
        val filter = sequenceOf(1, 2, 3, 4)
            .map { i ->
                println("map")
                i + 5
            }
            .filter { i ->
                println("filter")
                i < 7
            }
            .count()
        println(filter)
    }

    data class Point(var x: Int, var y: Int) {

    }

    operator fun Point.plus(p: Point): Point {
        x += p.x
        y += p.y
        return this
    }

    fun Point.plus(value: Int) {
        println("x = {x +value}, y = {y+value}")
    }

    @Test
    fun playPoint() {
        var p1 = Point(1, 2)
        val p2 = Point(3, 4)
        val p = p1 + p2

        println("p: ${p}")
        p1 += p
        println("p1: ${p1}")

//        val j1 = JavaPoint(1, 2)
//        val j2 = JavaPoint(5, 6)
//        val j = j1 + j2
//        println("j: ${j}")
    }

    @Test
    fun map() {
        val map = mapOf(1 to 1, 2 to "two")
        map.mapValues { (key, value) ->
            "key = $key ,value = $value "
        }
        var list: MutableList<CharSequence> = ArrayList();
        list.add("younger")
    }

    open class A {
        private var name: String = ""
            get() = field
            set(value) {
                field = value
            }

    }

    class B : A() {

    }

    interface C<in T : A> {
        fun play(t: T)
    }

    fun play() {
        object : C<B> {
            override fun play(t: B) {

            }

        }
    }

    fun test(name: String) {
        println("name: ${name}")
    }

    @Test
    fun kFunction() {
        val func = ::test
        func("orange")
        func.invoke("sunshine")
        func.call()
    }
}