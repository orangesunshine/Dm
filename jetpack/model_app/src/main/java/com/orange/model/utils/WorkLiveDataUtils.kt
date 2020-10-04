package com.orange.model.utils

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.orange.model.viewmodel.MainLiveDataModel

class WorkLiveDataUtils(var model: MainLiveDataModel) : LifecycleObserver {
    val TAG = javaClass.canonicalName
    var runFlag = true

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Thread {
            while (runFlag) {
                SystemClock.sleep(1000)
                model.add()
            }
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        runFlag = false
        Log.e(TAG, "onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
    }
}