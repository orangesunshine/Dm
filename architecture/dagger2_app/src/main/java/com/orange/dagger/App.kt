package com.orange.dagger

import android.app.Application
import com.orange.dagger.component.AppComponent
import com.orange.dagger.component.DaggerAppComponent

/**
 * @Description:
 * @Author: orange
 * @Date: 2020/9/28 8:48 PM
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}