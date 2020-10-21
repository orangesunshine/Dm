package com.orange.mvvm.test.binds

import android.util.Log
import javax.inject.Inject

class AmericaEngine @Inject constructor():Engine{
    override fun on() {
        Log.i("zrm", "AmericaEngine on")
    }
    override fun off() {
        Log.i("zrm", "AmericaEngine off")
    }
}