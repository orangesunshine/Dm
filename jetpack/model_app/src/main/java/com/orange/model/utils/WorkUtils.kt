package com.orange.model.utils

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.orange.model.viewmodel.MainViewModel

class WorkUtils(var model: MainViewModel) : LifecycleObserver {
    val TAG = javaClass.canonicalName
    var runFlag = true

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        Thread {
            while (runFlag) {
                SystemClock.sleep(1000)
                Log.e(TAG, "count: ${++model.count}")
            }
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        runFlag = false
        Log.e(TAG,"onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
    }
}