package com.orange.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orange.mvp.component.DaggerIComponent
import com.orange.mvp.contract.IDmContract
import javax.inject.Inject


class ActivityA : AppCompatActivity() {
    @Inject
    lateinit var presenter:IDmContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        DaggerIComponent.create().inject(this)
        var msg = presenter.getMsg()
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        findViewById<View>(R.id.tv_content).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        })
    }
}