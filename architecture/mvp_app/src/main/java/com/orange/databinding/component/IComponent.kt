package com.orange.mvp.component

import com.orange.mvp.ActivityA
import com.orange.mvp.module.DmModule
import com.orange.mvp.module.PreModule
import dagger.Component

@Component(modules = arrayOf(DmModule::class, PreModule::class))
interface IComponent {
    fun inject(act: ActivityA)
}