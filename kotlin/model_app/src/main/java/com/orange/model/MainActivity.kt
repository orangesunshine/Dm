package com.orange.model

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.orange.model.fragment.OneFragment
import com.orange.model.fragment.TwoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(TwoFragment())

        bt_one.setOnClickListener{
            replaceFragment(OneFragment())
        }
        bt_two.setOnClickListener{
            replaceFragment(TwoFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fl,fragment)
        transaction.commit()
    }

    override fun onDestroy() {
        Log.e("ViewModelActivity", "onDestroy")
        super.onDestroy()
    }
}