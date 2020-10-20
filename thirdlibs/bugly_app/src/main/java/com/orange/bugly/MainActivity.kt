package com.orange.bugly

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.tencent.bugly.beta.Beta
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_check.setOnClickListener(View.OnClickListener {
            Beta.checkUpgrade()
        })

        bt_info.setOnClickListener(View.OnClickListener {
            val upgradeInfo = Beta.getUpgradeInfo()
            val info = StringBuilder()
            upgradeInfo?.let {
                info.append("id: ").append(upgradeInfo.id).append("\n")
                info.append("标题: ").append(upgradeInfo.title).append("\n")
                info.append("升级说明: ").append(upgradeInfo.newFeature).append("\n")
                info.append("versionCode: ").append(upgradeInfo.versionCode).append("\n")
                info.append("versionName: ").append(upgradeInfo.versionName).append("\n")
                info.append("发布时间: ").append(SimpleDateFormat().format(Date(upgradeInfo.publishTime))).append("\n")
                info.append("安装包Md5: ").append(upgradeInfo.apkMd5).append("\n")
                info.append("安装包下载地址: ").append(upgradeInfo.apkUrl).append("\n")
                info.append("安装包大小: ").append(upgradeInfo.fileSize).append("\n")
                info.append("弹窗间隔（ms）: ").append(upgradeInfo.popInterval).append("\n")
                info.append("弹窗次数: ").append(upgradeInfo.popTimes).append("\n")
                info.append("发布类型（0:测试 1:正式）: ").append(upgradeInfo.publishType).append("\n")
                info.append("弹窗类型（1:建议 2:强制 3:手工）: ").append(upgradeInfo.upgradeType).append("\n")
                info.append("图片地址：").append(upgradeInfo.imageUrl)
            }

            tv_content.setText(info);
        })
    }
}
