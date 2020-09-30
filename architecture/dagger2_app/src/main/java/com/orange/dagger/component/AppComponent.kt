package com.orange.dagger.component

import com.orange.dagger.ActivityA
import com.orange.dagger.ActivityB
import com.orange.dagger.module.ModuleB
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ModuleB::class))
interface AppComponent {
    fun inject(act: ActivityA)
    fun inject(act: ActivityB)
}