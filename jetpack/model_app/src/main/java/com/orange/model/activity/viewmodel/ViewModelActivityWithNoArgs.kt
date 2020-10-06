package com.orange.model.activity.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.orange.model.R
import com.orange.model.viewmodel.MainViewModel
import com.orange.model.viewmodel.NoArgsViewModel

class ViewModelActivityWithNoArgs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //不带参数初始化viewmodel
        var model = ViewModelProvider(this).get<NoArgsViewModel>(
            NoArgsViewModel::class.java
        )
    }
}