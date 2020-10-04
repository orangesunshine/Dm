package com.orange.mvvm.repository

import com.orange.mvvm.data.ImageBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface BingImageService {
    @GET("HPImageArchive.aspx")
    fun getBingImage(
        @Query("format") format: String?,
        @Query("idx") idx: Int,
        @Query("n") n: Int
    ): Observable<ImageBean>
}