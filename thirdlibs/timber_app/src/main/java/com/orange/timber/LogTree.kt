package com.orange.timber

import android.util.Log
import androidx.multidex.BuildConfig
import timber.log.Timber

class LogTree : Timber.DebugTree() {
    val tags = listOf("younger")
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (BuildConfig.DEBUG || tags.contains(tag) && isLoggable(tag, Log.DEBUG)) {
            super.log(priority, tag, message, t)
        }
    }
}