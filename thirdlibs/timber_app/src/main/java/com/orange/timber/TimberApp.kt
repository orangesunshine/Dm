package com.orange.timber

import android.app.Application
import android.content.Context
import timber.log.Timber

class TimberApp:Application(){
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        Timber.plant(CrashReportingTree())
        Timber.d(NullPointerException("我怎么就空了"))
    }
}