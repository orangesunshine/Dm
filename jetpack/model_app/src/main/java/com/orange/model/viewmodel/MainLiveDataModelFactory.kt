package com.orange.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.orange.model.livedata.MainLiveDataModel

class MainLiveDataModelFactory(var count: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainLiveDataModel(count) as T
    }

}