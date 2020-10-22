package com.orange.mvvm.test.entrypoint

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Dog @Inject constructor(context: Context) {
    lateinit var work: Work
    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface DogEntries {
        fun provideWork(): Work
    }

    init {
        work = EntryPoints.get(context, DogEntries::class.java).provideWork()
    }
}