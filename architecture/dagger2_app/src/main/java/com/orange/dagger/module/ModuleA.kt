package com.orange.dagger.module

import com.orange.dagger.ActivityScoped
import com.orange.dagger.data.DataA
import com.orange.dagger.data.DataB
import dagger.Module
import dagger.Provides

@Module
class ModuleA {

    @ActivityScoped
    @Provides
    fun getA(): DataA {
        println("ModuleA->DataA()")
        return DataA()
    }

    @ActivityScoped
    @Provides
    fun getB(): DataB {
        println("ModuleA->DataB()")
        return DataB()
    }
}