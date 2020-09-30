package com.orange.databinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.orange.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val person = Person("younger", 33)
        contentView.person = person
        tv_name.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "age change", Toast.LENGTH_LONG).show()
            person.age.set(66)
        })
    }
}