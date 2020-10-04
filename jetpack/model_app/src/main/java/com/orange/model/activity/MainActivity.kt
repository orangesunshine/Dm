package com.orange.model.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.orange.model.R
import com.orange.model.utils.WorkLiveDataUtils
import com.orange.model.utils.WorkUtils
import com.orange.model.fragment.TwoFragment
import com.orange.model.viewmodel.MainLiveDataModel
import com.orange.model.viewmodel.MainLiveDataModelFactory
import com.orange.model.viewmodel.MainModelFactory
import com.orange.model.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewmodel
//        var model = ViewModelProvider(this).get<MainViewModel>(
//            MainViewModel::class.java
//        )

        val liveModel = ViewModelProvider(
            this,
            MainLiveDataModelFactory(1000)
        ).get(MainLiveDataModel::class.java)
        lifecycle.addObserver(WorkLiveDataUtils(liveModel))

        liveModel.count().observeForever(Observer {
            tv_add.text = it.toString()
        })

        replaceFragment(TwoFragment())

        //viewmodel-factory
        val count = 100
        val model = ViewModelProvider(this, MainModelFactory(count)).get(MainViewModel::class.java)
        lifecycle.addObserver(WorkUtils(model))
        bt_one.setOnClickListener {
            model.count = 500
            //    replaceFragment(OneFragment())
        }
        bt_two.setOnClickListener {
            //    replaceFragment(TwoFragment())
            startActivity(Intent(this,LiveDataMapActivity::class.java))
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fl, fragment)
        transaction.commit()
    }

    override fun onDestroy() {
        Log.e("ViewModelActivity", "onDestroy")
        super.onDestroy()
    }
}