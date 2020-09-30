package com.orange.dagger.module

import com.orange.dagger.ActivityScoped
import com.orange.dagger.data.DataA
import com.orange.dagger.data.DataB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleB {

    @Singleton
    @Provides
    fun getA(): DataA {
        println("ModuleB->DataA()")
        return DataA()
    }

    @Singleton
    @Provides
    fun getB(): DataB {
        println("ModuleB->DataB()")
        return DataB()
    }
}