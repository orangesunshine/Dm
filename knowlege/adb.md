### 常用cmd
adb devices：查看Android设备是否连接到电脑。

adb shell dumpsys activity：查看当前运行的是哪个activity,运行的一些进程等

adb shell dumpsys activity activities

adb shell pm list packages：列出所有的包名。

adb shell dumpsys package：列出所有的安装应用的信息

adb shell dumpsys package com.android.XXX：查看某个包的具体信息

adb shell dumpsys activity | grep mFocusedActivity：查看当前resume的是哪个activity

adb logcat | grep ActivityManager：查看当前正在运行的Activity

adb logcat | grep Displayed：查看当前正在运行的Activity

***aapt：aapt dump badging D:\XXX.apk