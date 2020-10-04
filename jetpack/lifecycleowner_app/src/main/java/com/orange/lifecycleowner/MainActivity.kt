package com.orange.lifecycleowner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.orange.lifecycleowner.databinding.ActivityMainBinding
import com.orange.lifecycleowner.model.WorkUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val databinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        lifecycle.addObserver(WorkUtils)
    }
}