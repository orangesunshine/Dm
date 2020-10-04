package com.orange.model.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.orange.model.App
import com.orange.model.R
import com.orange.model.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_two.*

class TwoFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_two,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider.AndroidViewModelFactory(App.app).create(SharedViewModel::class.java)
        Log.e("TwoFragment","model.sharedName: ${model.sharedName.value}")
        model.sharedName.observe(this, Observer {
            tv.text = it
        })
    }

    override fun onDestroy() {
        Toast.makeText(activity, "TwoFragment is destroyed", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}