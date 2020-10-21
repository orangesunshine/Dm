package com.orange.mvvm.test.binds

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MainModule {

    @Provides
    @MadeInCN
    fun provideChinaCar(engin: ChinaEngin): ChinaCar = ChinaCar(engin)

    @Provides
    @MadeInUSA
    fun provideChinaCar2(engin: AmericaEngine): ChinaCar = ChinaCar(engin)
}
