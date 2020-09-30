### @Singleton
> 单个activity单例
1. module @Provides 加上 @Singleton
2. 对应的component也要加上 @Singleton
双@Singleton，DoubleCheck缓存实例，实现单例，只能保证component内单例

> 多个activity单例（通过单例component）
1. 默认create会有多个component，导致单例被破坏；app是全局的，在app中确保component只有一个，通过方法返回comopent单例

### di 依赖注入
1. 依赖：@Inject方式
2. 注入：@Inject构造方法，@module @provides方法

`mvp：通过module @provides 返回present`