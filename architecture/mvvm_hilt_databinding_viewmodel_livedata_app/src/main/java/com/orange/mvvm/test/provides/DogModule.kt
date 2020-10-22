package com.orange.mvvm.test.provides

import com.orange.mvvm.test.entrypoint.Work
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ActivityComponent::class)
class DogModule {
    @Provides
    fun provideDog(): Dog = Dog("二哈")

    @Provides
    fun provideWork():Work = Work()
}