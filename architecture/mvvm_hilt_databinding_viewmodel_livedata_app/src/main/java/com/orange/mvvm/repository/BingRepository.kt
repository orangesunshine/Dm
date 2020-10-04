package com.orange.mvvm.repository

import com.orange.mvvm.data.ImageBean
import io.reactivex.Observable
import javax.inject.Inject

class BingRepository @Inject constructor(var dataSource: BingRemoteDataSource) {

    fun getBingImage(format: String, idx: Int, n: Int): Observable<ImageBean> {
        return dataSource.getBingImage(format, idx, n)
    }
}