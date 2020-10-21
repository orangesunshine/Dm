package com.orange.mvvm.test.provides

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class DogModule {
    @Provides
    fun provideDog(): Dog = Dog("二哈")
}