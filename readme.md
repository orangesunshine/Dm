### gradle plugin
#### 1. 通过gradle文件引入
1). 创建一个class作为extension
```groovy
class HelloExtension{
    String msg; 
}
```

2). 实现Plugin<Project>接口并实现apply方法
```groovy
class HelloPlugin implements com.orange.plugin.Plugin<Project>{
    @Override
    void apply(Project target) {                                
        //arg1： gradle 申明变量，arg2： extension类
        def hello = target.extensions.create("hello",HelloExtension)
        target.task("hello"){
            doLast {
                println hello.msg
            }
        }
    }
}
```

3).引入plugin，gradle文件申明变量，引入gradle文件
> 引入plugin
    apply plugin: HelloPlugin
> gradle文件变量申明(必须先引入plugin，后申明变量)
    hello{
        msg = 'hello younger'
    }
>引入gradle文件(可以指定路径)
    apply from: '../plugin.gradle'

#### 2. buildSrc工程方式：buildSrc是android保留工程，不用写入setting.gradle
`现在buildSrc这个名字被保留给传统的构建额外逻辑的buildSrc工程`
1). buildSrc工程结构，新建src/main/java&groovy/package(com.xx.xx)
2). buildSrc根路径下新建build.gradle，写入
```groovy
//  buildSrc/build.gradle
apply plugin: 'groovy'
dependencies {
    compile gradleApi()
    compile localGroovy()
}
```
3). 编写Plugin类
```groovy
package com.orange.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomBuildSrcPlugin implements Plugin<Project>{
    @Override
    void apply(Project project) {
        def user = project.extensions.create("orange",Ext)
        project.task('showCustomPluginInBuildSrc') {
            doLast {
                println("InBuildSrc: Module Name is $project.name")
                println user.name
            }
        }
    }
}
```
4). 配置plugin：buildSrc目录下创建resources/META-INF/gradle-plugins/id.properties
```properties
// 在app模块下的build.gradle文件中引用
implementation-class=com.orange.plugin.CustomBuildSrcPlugin
```
5). 引入plugin 
```groovy
// 在app模块下的build.gradle文件中引用
apply plugin: 'id(CustomPlugin)'//第4步id

import com.orange.plugin.CustomBuildSrcPlugin
apply plugin: CustomBuildSrcPlugin

apply plugin: com.orange.plugin.CustomBuildSrcPlugin
```
#### 3. 通过maven
1). uploadArchives上传到本地maven仓库：build.gradle 配置如下，执行uploadArchives任务
```groovy
uploadArchives{
    repositories{
        mavenDeployer{
            pom.groupId = "com.orange.plugin"
            pom.artifactId = "orangePlugin"
            pom.version = "1.0.0"
            repository(url: uri("./orange"))
        }
    }
}
```
2). 引用本地maven仓库
```groovy
buildscript {
    repositories {
        maven{
            url uri('./pluginMaven/orange')
        }
    }
    dependencies {
        classpath "com.orange.plugin:orangePlugin:1.0.0"
    }
}
```

### 创建task三种方式
1). project.task(taskname){doLast{}}
2). tasks.create(taskname){doFirst {}}
3). 
```groovy
class MyTask extends DefaultTask {
    
    @TaskAction
    void action(){
        println "action1+++++"
    }
}

//创建 hello3 task
task hello3 (type: MyTask){
    doLast{
       println "action2+++++"
    }
}
```

