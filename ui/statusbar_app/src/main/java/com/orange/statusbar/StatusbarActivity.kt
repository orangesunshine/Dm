package com.orange.statusbar

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class StatusbarActivity : AppCompatActivity() {
    val flag = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statusbar)
        /**SYSTEM_UI_FLAG_LOW_PROFILE："低调模式"
         * 状态栏和/或导航图标可能会变暗
         */

        /**
         * View.SYSTEM_UI_FLAG_FULLSCREEN
         * 正常的全屏模式,内容可以覆盖屏幕，交互(比如触摸屏幕顶部)后悔清除此flag。
         * 同android.view.WindowManager.LayoutParams#FLAG_FULLSCREEN
         * 装饰栏(如状态栏)在当前窗口隐藏
         * 可以覆盖掉ActionBar(oppo 测试失败)
         */

        /**
         * View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
         * actionbar覆盖布局文件
         */

        /**
         * SYSTEM_UI_FLAG_LAYOUT_STABLE
         * 常和ui悬浮、隐藏共用，使view不会因system ui变化而重新layout
         */

        /**
         * SYSTEM_UI_FLAG_IMMERSIVE：专门的修饰符
         * 设置该flag，交互后不会清除flag（SYSTEM_UI_FLAG_HIDE_NAVIGATION）
         */

        /**
         * SYSTEM_UI_FLAG_IMMERSIVE_STICKY
         * 只能SYSTEM_UI_FLAG_FULLSCREEN and/or SYSTEM_UI_FLAG_HIDE_NAVIAGTION配合使用
         */

        /**
         * View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
         * 改状态栏与按钮的颜色的效果
         */

        /**
         * SYSTEM_UI_FLAG_VISIBLE
         * 系统正常默认的系统栏样式
         */

        /**
         * 设置全屏其他方法：
         *android：theme = “@ android：style / Theme.Holo.NoActionBar.Fullscreen” >
         *
         *if (Build.VERSION.SDK_INT < 16) {
         *  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
         *  WindowManager.LayoutParams.FLAG_FULLSCREEN);
         *}
         */

        /**
         * 状态栏半透明（21及以上）
         * <item name="android:windowTranslucentStatus">true</item>
         * android:fitsSystemWindows= true：防止view内容被状态栏覆盖（根布局中使用）
         */
        supportActionBar?.hide()
        fullScreenTransparentStatusbar()
        //normalImmersive()
    }

    private fun fullScreenTransparentStatusbar() {

        window.decorView.systemUiVisibility = flag
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.BLACK
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            //flag用户交互后清除，通过监听重置flag
            //window.decorView.systemUiVisibility = flag
        }
    }

    fun normalImmersive() {
        // 设置状态栏全透明
        // 设置状态栏全透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility =
                SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }
}