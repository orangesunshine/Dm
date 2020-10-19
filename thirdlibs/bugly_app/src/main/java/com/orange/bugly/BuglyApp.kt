package com.orange.bugly

import android.app.Application
import android.os.Environment
import android.os.Process
import android.util.Log
import com.tencent.bugly.Bugly
import com.tencent.bugly.beta.Beta
import com.tencent.bugly.beta.download.DownloadListener
import com.tencent.bugly.beta.download.DownloadTask
import com.tencent.bugly.beta.upgrade.UpgradeStateListener
import com.tencent.bugly.crashreport.CrashReport

class BuglyApp : Application() {
    val TAG = javaClass.simpleName
    override fun onCreate() {
        super.onCreate()
        initBugly()
        CrashReport.setUserSceneTag(this, 171664)
    }

    private fun initBugly() {

        /**** Beta高级设置*****/
        /**
         * true表示app启动自动初始化升级模块；
         * false不好自动初始化
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false
         * 在后面某个时刻手动调用
         */
        /**** Beta高级设置 */
        /**
         * true表示app启动自动初始化升级模块；
         * false不好自动初始化
         * 开发者如果担心sdk初始化影响app启动速度，可以设置为false
         * 在后面某个时刻手动调用
         */
        Beta.autoInit = true

        /**
         * true表示初始化时自动检查升级
         * false表示不会自动检查升级，需要手动调用Beta.checkUpgrade()方法
         */
        /**
         * true表示初始化时自动检查升级
         * false表示不会自动检查升级，需要手动调用Beta.checkUpgrade()方法
         */
        Beta.autoCheckUpgrade = true

        /**
         * 设置升级周期为60s（默认检查周期为0s），60s内SDK不重复向后天请求策略
         */
        /**
         * 设置升级周期为60s（默认检查周期为0s），60s内SDK不重复向后天请求策略
         */
        Beta.initDelay = 1 * 1000.toLong()

        /**
         * 设置通知栏大图标，largeIconId为项目中的图片资源；
         */
        /**
         * 设置通知栏大图标，largeIconId为项目中的图片资源；
         */
        Beta.largeIconId = R.mipmap.ic_launcher

        /**
         * 设置状态栏小图标，smallIconId为项目中的图片资源id;
         */
        /**
         * 设置状态栏小图标，smallIconId为项目中的图片资源id;
         */
        Beta.smallIconId = R.mipmap.ic_launcher


        /**
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        /**
         * 设置更新弹窗默认展示的banner，defaultBannerId为项目中的图片资源Id;
         * 当后台配置的banner拉取失败时显示此banner，默认不设置则展示“loading“;
         */
        Beta.defaultBannerId = R.mipmap.ic_launcher

        /**
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;
         */
        /**
         * 设置sd卡的Download为更新资源保存目录;
         * 后续更新资源会保存在此目录，需要在manifest中添加WRITE_EXTERNAL_STORAGE权限;
         */
        Beta.storageDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        /**
         * 点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        /**
         * 点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
         */
        Beta.showInterruptedStrategy = false

        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
        Beta.canShowUpgradeActs.add(MainActivity::class.java)

        val context = applicationContext
        // 获取当前包名
        val packageName = context.packageName
        // 获取当前进程名
        val processName =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                getProcessName()
            } else {
                Apps.getProcessName(Process.myPid())
            }
        // 设置是否为上报进程
        val strategy = CrashReport.UserStrategy(context)
        strategy.setUploadProcess(processName == null || processName == packageName)

        //监听安装包下载状态
        Beta.downloadListener = object : DownloadListener {
            override fun onReceive(downloadTask: DownloadTask) {
                Log.d(TAG, "downloadListener receive apk file")
            }

            override fun onCompleted(downloadTask: DownloadTask) {
                Log.d(
                    TAG,
                    "downloadListener download apk file success"
                )
            }

            override fun onFailed(downloadTask: DownloadTask, i: Int, s: String) {
                Log.d(
                    TAG,
                    "downloadListener download apk file fail"
                )
            }
        }

        //监听APP升级状态

        //监听APP升级状态
        Beta.upgradeStateListener = object : UpgradeStateListener {
            override fun onUpgradeFailed(b: Boolean) {
                Log.d(TAG, "upgradeStateListener upgrade fail")
            }

            override fun onUpgradeSuccess(b: Boolean) {
                Log.d(
                    TAG,
                    "upgradeStateListener upgrade success"
                )
            }

            override fun onUpgradeNoVersion(b: Boolean) {
                Log.d(
                    TAG,
                    "upgradeStateListener upgrade has no new version"
                )
            }

            override fun onUpgrading(b: Boolean) {
                Log.d(TAG, "upgradeStateListener upgrading")
            }

            override fun onDownloadCompleted(b: Boolean) {
                Log.d(
                    TAG,
                    "upgradeStateListener download apk file success"
                )
            }
        }

        // 初始化Bugly
        Bugly.init(
            context,
            BuildConfig.BUGLY_APPID,
            BuildConfig.DEBUG,
            strategy
        )
    }
}