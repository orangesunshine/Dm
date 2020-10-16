### release中打出日志
1. 创建data/local.prop文件，并输入：
log.tag.YOUNGER=DEBUG

2.adb shell setprop log.tag.YOUNGER DEBUG 
tag（YOUGNER） level（DEBUG）

3. Timber.tag("YOUNGER")
TImber.d(log)
输出tag为"YOUNGER"的log信息