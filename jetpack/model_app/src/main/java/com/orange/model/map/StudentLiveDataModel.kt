package com.orange.model.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel

class StudentLiveDataModel(stu: Student) : ViewModel() {
    private var studentmld = MutableLiveData(stu)
    private var studentld: LiveData<Student> = studentmld
    private var score: LiveData<Double> = map(studentmld, { it.score })

    fun getStudent(): LiveData<Student> {
        return studentld
    }

    fun getStuScore():LiveData<Double>{
        return score
    }

    fun getMutableStudent(): MutableLiveData<Student> {
        return studentmld
    }

    fun setStudent(stu: Student) {
        studentmld.value = stu
    }

    override fun onCleared() {
        super.onCleared()
    }
}