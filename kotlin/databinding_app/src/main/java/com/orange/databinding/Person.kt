package com.orange.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

/**
 * 可观察对象
 * 使用Bindable注解注册通知，当值改变的时候通过notifyPropertyChanged()发送通知
 */
//class Person() : BaseObservable() {
//
//    @get:Bindable
//    var name: String? = null
//        set(_name) {
//            field = _name
//            notifyPropertyChanged(BR.name)
//        }
//
//    @get:Bindable
//    var age: Int? = null
//        set(_age) {
//            field = _age
//            notifyPropertyChanged(BR.age)
//        }
//
//    constructor(_name: String, _age: Int):this() {
//        name = _name
//        age = _age
//    }
//}

/**
 * 可观察数据字段
 */
class Person() {
    var name = ObservableField<String>()
    var age = ObservableField<Int>()

    constructor(_name: String, _age: Int) : this() {
        name.set(_name)
        age.set(_age)
    }
}