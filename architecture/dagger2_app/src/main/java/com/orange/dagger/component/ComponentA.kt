package com.orange.dagger.component

import com.orange.dagger.ActivityA
import com.orange.dagger.ActivityB
import com.orange.dagger.ActivityScoped
import com.orange.dagger.module.ModuleA
import dagger.Component

@ActivityScoped
@Component(modules = arrayOf(ModuleA::class))
interface ComponentA {
    fun injectA(act: ActivityA)
    fun injectB(act: ActivityB)
}