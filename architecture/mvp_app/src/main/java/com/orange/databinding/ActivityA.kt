package com.orange.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.orange.mvp.component.DaggerIComponent
import com.orange.mvp.contract.IDmContract
import javax.inject.Inject


class ActivityA : AppCompatActivity(),IDmContract.View {
    @Inject
    lateinit var presenter:IDmContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        DaggerIComponent.create().inject(this)
        presenter.attach(this)
        presenter.getMsg()
        findViewById<View>(R.id.tv_content).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        })
    }

    override fun showMsg(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}