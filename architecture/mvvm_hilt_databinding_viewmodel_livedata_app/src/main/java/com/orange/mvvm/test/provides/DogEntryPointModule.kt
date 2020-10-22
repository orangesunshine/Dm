package com.orange.mvvm.test.provides

import android.content.Context
import com.orange.mvvm.test.entrypoint.Dog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class DogEntryPointModule {

    @Provides
    fun provideDog(@ActivityContext context: Context):Dog = Dog(context)
}