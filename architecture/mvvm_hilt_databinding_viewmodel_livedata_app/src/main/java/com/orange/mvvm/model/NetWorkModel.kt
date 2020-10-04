package com.orange.mvvm.model

import com.orange.mvvm.net.RetrofitProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit


@Module
@InstallIn(ApplicationComponent::class)
class NetWorkModel {

    @Provides
    fun getRetrofit(): Retrofit {
        return RetrofitProvider.create()
    }
}