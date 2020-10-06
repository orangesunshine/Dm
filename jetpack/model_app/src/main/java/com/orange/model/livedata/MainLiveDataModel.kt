package com.orange.model.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainLiveDataModel(count: Int) : ViewModel() {
    private var mCount = MutableLiveData<Int>()
    private var mLiveDataCount:LiveData<Int> = mCount

    init {
        mCount.value = count
    }

    fun add() {
        mCount.postValue(mCount.value?.let { it + 1 })
    }

    fun count(): LiveData<Int> {
        return mLiveDataCount
    }
}