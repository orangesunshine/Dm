package com.orange.mvvm.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orange.mvvm.R
import com.orange.mvvm.test.binds.*
import com.orange.mvvm.test.entrypoint.Dog
import com.orange.mvvm.test.entrypoint.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_test.*
import javax.inject.Inject

@AndroidEntryPoint
class TestActivity : AppCompatActivity() {
    @Inject
    lateinit var dog: Dog

    @Inject
    lateinit var engin: ChinaEngin

    @Inject
    @MadeInCN
    lateinit var car2: ChinaCar

    @Inject
    @MadeInUSA
    lateinit var car3: ChinaCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        tv_content.text = engin.javaClass.name
        tv_content.append("\ncar2: ${car2.engin.javaClass.name}")
        tv_content.append("\ncar3: ${car3.engin.javaClass.name}")
        val work = dog.work
        println()
    }
}