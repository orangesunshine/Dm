package com.orange.mvvm.repository

import com.orange.mvvm.data.ImageBean
import com.orange.mvvm.net.RetrofitProvider
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BingRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    fun getBingImage(format: String, idx: Int, n: Int): Observable<ImageBean> {
        retrofit.baseUrl()
        return retrofit.create(BingImageService::class.java).getBingImage(format, idx, n)
    }
}