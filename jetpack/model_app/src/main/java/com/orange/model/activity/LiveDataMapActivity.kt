package com.orange.model.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.orange.model.R
import com.orange.model.databinding.ActivityLivedataMapBinding
import com.orange.model.map.Student
import com.orange.model.map.StudentLiveDataModel
import com.orange.model.map.StudentLiveDataModelFactory
import com.orange.model.utils.HttpUtils
import kotlinx.android.synthetic.main.activity_livedata_map.*


class LiveDataMapActivity : AppCompatActivity() {
    private var TAG = this.javaClass.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = DataBindingUtil.setContentView<ActivityLivedataMapBinding>(
            this,
            R.layout.activity_livedata_map
        )
        observeStu(binding)
    }

    fun observeStu(binding: ActivityLivedataMapBinding){
        val stu = Student("younger", 88.0, 13)
        val model = ViewModelProvider(
            this,
            StudentLiveDataModelFactory(stu)
        ).get(StudentLiveDataModel::class.java)

        btn_save.setOnClickListener(View.OnClickListener {
            val score = ed_socre.text.toString().toDouble()
            stu.score = score
            model.setStudent(stu)
        })

        model.getStudent().observeForever(Observer {
            val score = it.score.toString()
            binding.tvStuscore.text = score
            //tv_stuscore.text = score
        })
    }

    fun observeScore(binding: ActivityLivedataMapBinding){
        btn_save.setOnClickListener(View.OnClickListener {
            val score = ed_socre.text.toString().toDouble()
            HttpUtils.setScore(score)
        })

        HttpUtils.getStuLiveData().observeForever(Observer {
            binding.student = it
        })
    }
}