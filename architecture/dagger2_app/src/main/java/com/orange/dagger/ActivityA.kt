package com.orange.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orange.dagger.data.DataA
import javax.inject.Inject


class ActivityA : AppCompatActivity() {
    @Inject
    lateinit var dataA: DataA

    @Inject
    lateinit var dataACopy: DataA


    fun play() {
        println("dataA: ${dataA}, dataACopy: ${dataACopy}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
//        val build = App.getAppComponent()
//        build.inject(this)
//        println("build: ${build}, dataA: ${dataA}, dataACopy: ${dataACopy}")
//        findViewById<View>(R.id.tv_content).setOnClickListener(View.OnClickListener {
//            startActivity(Intent(this,ActivityB::class.java))
//        })
    }
}