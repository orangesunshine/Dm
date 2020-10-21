package com.orange.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.orange.mvvm.databinding.ActivityMainBinding
import com.orange.mvvm.test.TestActivity
import com.orange.mvvm.viewmodel.BingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<BingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        viewModel.getImage().observe(this, Observer {
            binding.image = it
        })

        bt_one.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }

        viewModel.getBingImage("js", 1, 1)
    }
}