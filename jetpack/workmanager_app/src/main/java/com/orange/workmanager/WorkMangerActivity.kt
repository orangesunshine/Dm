package com.orange.workmanager

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.orange.workmanager.work.NotificationWorker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class WorkMangerActivity : AppCompatActivity() {
    val request: OneTimeWorkRequest =
        OneTimeWorkRequest.Builder(NotificationWorker::class.java)
            .build()

    val perDayReq: PeriodicWorkRequest =
        PeriodicWorkRequest.Builder(NotificationWorker::class.java, 1, TimeUnit.DAYS).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var workManager = WorkManager.getInstance(this)
        bt_one.setOnClickListener(View.OnClickListener {
            workManager.enqueue(request)
        })

        workManager.getWorkInfoByIdLiveData(request.id)
            .observe(this, Observer { workInfo ->
                if (workInfo != null) {
                    val status: String = workInfo.state.name
                    tv_content.text = status
                }
            })

        bt_two.setOnClickListener(View.OnClickListener {
            workManager.enqueue(perDayReq)
        })
    }
}