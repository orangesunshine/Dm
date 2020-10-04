package com.orange.lifecycleowner.model

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

object WorkUtils : LifecycleObserver {
    val TAG = javaClass.canonicalName
    var count: Int = 0
    var runFlag = true

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Thread {
            while (runFlag) {
                SystemClock.sleep(1000)
                Log.e(TAG, "count: ${++count}")
            }
        }.start()
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop(){
        runFlag = false
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        count = 0
    }
}