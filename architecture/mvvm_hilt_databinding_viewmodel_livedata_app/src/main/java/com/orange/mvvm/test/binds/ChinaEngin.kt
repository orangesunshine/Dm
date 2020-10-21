package com.orange.mvvm.test.binds

import android.util.Log
import javax.inject.Inject

class ChinaEngin @Inject constructor() : Engine {
    override fun on() {
        Log.i("zrm", "ChinaEngine on")
    }

    override fun off() {
        Log.i("zrm", "ChinaEngine off")
    }
}

class ChinaCar @Inject constructor(var engin: Engine) {
    lateinit var name: String
}