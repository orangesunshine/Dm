package com.orange.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orange.jetpack.databinding.ActivityMainBinding

class ViewBindingActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflate = ActivityMainBinding.inflate(layoutInflater)
        setContentView(inflate.root)
        inflate.tvName.text = "YOUNGER"
        inflate.tvAge.text = "33"
    }
}