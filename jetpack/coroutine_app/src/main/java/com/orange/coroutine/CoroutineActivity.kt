package com.orange.coroutine

import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runCoroutines()
    }

    private fun runCoroutines() {
        GlobalScope.launch(Dispatchers.Main) {
            val data = getData()//获取网络接口数据
            Toast.makeText(this@CoroutineActivity,"getData Over",Toast.LENGTH_LONG).show()
            val processedData = processData(data)//处理数据
            bt_one.text = processedData//UI显示数据
        }
    }

    private suspend fun getData(): String {
        return withContext(Dispatchers.IO) {
            SystemClock.sleep(2000)
            "hen_coder"
        }
    }

    private suspend fun processData(data: String): String {
        return withContext(Dispatchers.IO) {
            SystemClock.sleep(5000)
            data.split("_")//把"hen_coder" 拆成 ["hen","coder"]
                .map { it.capitalize() }//把["hen","coder"]改成["Hen","Coder"]
                .reduce { acc, s -> acc + s }//把["Hen","Coder"]改成HenCoder
        }
    }

}