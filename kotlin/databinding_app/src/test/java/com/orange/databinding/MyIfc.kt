package com.orange.databinding

interface MyIfc {
    //抽象属性
    var height: Int

    //具体属性
    val name: String
        get() = ""

    val age: Int
        get() = 77

    //抽象方法
    fun play1()

    fun play2() {

    }
}

//继承实现抽象方法、属性
class MyClass : MyIfc {
    override var height: Int = 0
        get() = field
        set(value) {
            field = value
        }

    override val age: Int = 0
        get() = field

    override fun play1() {

    }

}
