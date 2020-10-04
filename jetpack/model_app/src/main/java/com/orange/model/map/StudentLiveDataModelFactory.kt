package com.orange.model.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudentLiveDataModelFactory(var stu:Student) :ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentLiveDataModel(stu) as T
    }

}