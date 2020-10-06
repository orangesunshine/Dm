package com.orange.model.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.orange.model.R
import com.orange.model.activity.viewmodel.ViewModelActivityWithNoArgs
import com.orange.model.activity.viewmodel.ViewModelNdLiveDataActivity
import com.orange.model.utils.WorkLiveDataUtils
import com.orange.model.utils.WorkUtils
import com.orange.model.fragment.TwoFragment
import com.orange.model.livedata.MainLiveDataModel
import com.orange.model.viewmodel.MainLiveDataModelFactory
import com.orange.model.viewmodel.MainModelFactory
import com.orange.model.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewmodel-factory
        val count = 100
        val model = ViewModelProvider(this, MainModelFactory(count)).get(MainViewModel::class.java)
        lifecycle.addObserver(WorkUtils(model))
        bt_one.setOnClickListener {
            model.count = 500
        }
        bt_one.setOnClickListener {
            startActivity(Intent(this,ViewModelNdLiveDataActivity::class.java))
        }

        bt_two.setOnClickListener {
            startActivity(Intent(this,LiveDataMapActivity::class.java))
        }
    }

}