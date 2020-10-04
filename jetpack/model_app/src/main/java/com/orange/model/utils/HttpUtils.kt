package com.orange.model.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.orange.model.map.Student


object HttpUtils {
    private var score = MutableLiveData<Double>()
    private var studentLiveData =
        Transformations.switchMap<Double, Student>(this.score, { getStudent(it) })

    fun setScore(score: Double) {
        this.score.value = score
    }

    fun getStuLiveData(): LiveData<Student> {
        return studentLiveData
    }

    fun getStudent(score: Double): LiveData<Student> {
        val studentMutableLiveData = MutableLiveData<Student>()
        val student = Student("黄", score, 23)
        studentMutableLiveData.setValue(student)
        return studentMutableLiveData
    }
}

