package com.orange.productFlavors

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val metaDataFromApp = getMetaDataFromApp(this.applicationContext, "placeholders1")
        tv_content.text = metaDataFromApp
    }

    //获取value
    private fun getMetaDataFromApp(context: Context?, metadataNmae: String): String? {
        if (null == context) return null
        val value = ""
        try {
            val appInfo = context.packageManager.getApplicationInfo(
                context.packageName,
                PackageManager.GET_META_DATA
            )
            if (null != appInfo) {
                val metaData = appInfo.metaData
                if (null != metaData) {
                    return metaData.getString(metadataNmae)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return value
    }
}
