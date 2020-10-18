### proguard 作用
1. 压缩：默认开启，减少apk体积，移除未被使用的类和成员；
    优化后可能再次暴露未使用类和成员，再次压缩
-dontshrink 关闭压缩

2. 优化：默认开启，字节码级别执行优化，让应用运行的更快
-dontoptimize 关闭优化
-optimizationpasses n 优化次数，android一般为5

3. 混淆：默认开启，类和类成员会被随机命名，增大反编译难度，除非用keep保护
-dontobfuscate 关闭混淆
    混淆后默认会在工程目录app/build/outputs/mapping/release下生成mapping.txt文件（即混淆规则），根据这个规则混淆后的代码可以反推回源代码
    
原则上混淆代码越乱越好，但是某些地方，混淆可能会导致程序运行出错；可以使用如下规则避免混淆，防止程序出错
-keep class 包名.path.** //保持包以及子包类名不混淆
-keep class 包名.path.* //保持包下类名，不保持子包类名被混淆

上面规则类名未混淆，但是方法和变量还是混淆了；
使用下面规则可以不混淆方法和变量
-keep 包名.path.* {*;}
-keep public class * extends android.app.Activity//通过java语法extends，implementation避免所有继承Activity的类不被混淆
内部类用$
-keep public class * extends android.app.Activity$InnnerClass{public *;}//Activity内部类InnerClass中所有public内容不被混淆

一个类部分不被混淆，可以使用如下语法
<init>; //匹配所有构造器
<fields>; //匹配所有域
<methods>; //匹配所有方法

//通过private、public等修饰符进一步限定
-keep class 包名.类名{
    public <methods>;
}

//进一步还可以给方法加上参数
-keep class 包名.类名{
    public <methods>(org.json.JSONObject);
}

//类名混淆，类下的特定方法不被混淆：keep会保持类名，keepclassmembers不会保持类名，移除是指在压缩(Shrinking)时是否会被删除
保留	                        防止被移除或者被重命名	    防止被重命名
类和类成员	                    -keep	                    -keepnames
仅类成员	                    -keepclassmembers	        -keepclassmembernames
如果拥有某成员，保留类和类成员	-keepclasseswithmembers	    -keepclasseswithmembernames

注意事项
1，jni方法不可混淆，因为这个方法需要和native方法保持一致；
-keepclasseswithmembernames class * { # 保持native方法不被混淆    
    native <methods>;
}

2，反射用到的类不混淆(否则反射可能出现问题)；

3，AndroidMainfest中的类不混淆，所以四大组件和Application的子类和Framework层下所有的类默认不会进行混淆。自定义的View默认也不会被混淆；所以像网上贴的很多排除自定义View，或四大组件被混淆的规则在Android Studio中是无需加入的；

4，与服务端交互时，使用GSON、fastjson等框架解析服务端数据时，所写的JSON对象类不混淆，否则无法将JSON解析成对应的对象；

5，使用第三方开源库或者引用其他第三方的SDK包时，如果有特别要求，也需要在混淆文件中加入对应的混淆规则；

6，有用到WebView的JS调用也需要保证写的接口方法不混淆，原因和第一条一样；

7，Parcelable的子类和Creator静态成员变量不混淆，否则会产生Android.os.BadParcelableException异常；
-keep class * implements Android.os.Parcelable { # 保持Parcelable不被混淆           
    public static final Android.os.Parcelable$Creator *;
}

8，使用enum类型时需要注意避免以下两个方法混淆，因为enum类的特殊性，以下两个方法会被反射调用，见第二条规则。
-keepclassmembers enum * {  
    public static **[] values();  
    public static ** valueOf(java.lang.String);  
}