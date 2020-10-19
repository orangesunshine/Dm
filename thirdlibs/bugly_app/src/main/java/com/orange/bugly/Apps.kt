package com.orange.bugly

import android.app.ActivityManager
import android.content.Context
import android.text.TextUtils
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException


object Apps {
    fun getProcessName(cxt: Context, pid: Int): String? {
        return (cxt.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)
            .runningAppProcesses.find { it.pid == pid }?.processName
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    fun getProcessName(pid: Int): String? {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(FileReader("/proc/$pid/cmdline"))
            var processName: String = reader.readLine()
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim { it <= ' ' }
            }
            return processName
        } catch (throwable: Throwable) {
        } finally {
            try {
                if (reader != null) {
                    reader.close()
                }
            } catch (exception: IOException) {
            }
        }
        return null
    }
}