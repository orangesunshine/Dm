### Logcat/Build 乱码
1. build.gradle 添加(未测试)
```groovy
tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}
```
2. Help->Edit Custom VM Options，在打开的文件里，增加 -Dfile.encoding=UTF-8（已测试）

### Cannot access androidx.lifecycle.HasDefaultViewModelProviderFactory
依赖viewmodel
