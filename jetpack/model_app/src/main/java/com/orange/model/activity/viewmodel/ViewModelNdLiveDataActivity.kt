package com.orange.model.activity.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.orange.model.R
import com.orange.model.livedata.MainLiveDataModel
import com.orange.model.utils.WorkLiveDataUtils
import com.orange.model.viewmodel.MainLiveDataModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class ViewModelNdLiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //带参数初始化viewModel
        val viewModel = ViewModelProvider(
            this,
            MainLiveDataModelFactory(1000)
        ).get(MainLiveDataModel::class.java)
        lifecycle.addObserver(WorkLiveDataUtils(viewModel))

        viewModel.count().observeForever(Observer {
            tv_add.text = it.toString()
        })
    }
}