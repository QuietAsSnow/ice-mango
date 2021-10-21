# 笔记

## 1.集成Mybatis遇到的问题
### MybatisConfig中的classpath

classpath是什么：

加载资源的路径，src/main/java, 以及/src/main/resources 下的文件都会编译到 target/classes中，这个classes即为classpath。

classpath*与classpath的区别：

*的意思就是可以匹配多个文件，而且可以匹配lib包中的文件。


### MybatisConfig
即mybatis集成所需配置，可以直接写在yml文件中。

### Mybatis JDBC Driver
必要的参数配置为：

1、useUnicode-是否使用unicode编码，默认为false。

2、characterEncoding-如果“useUnicode”被设置为“真”，处理字符串时，驱动程序应使用什么字符编码？ 默认为“autodetect”。默认值：无。

3、serverTimezone-覆盖时区的检测/映射。当服务器的时区为映射到Java时区时使用 默认值：无。

另外用到的两个参数：

4、zeroDateTimeBehavior-当驱动程序遇到全由0组成的DATETIME值时，应出现什么？MySQL使用它来表示无效日期。有效值是“exception”、“round”和“convertToNull”。默认值：exception。

5、autoReconnect-当数据库连接异常中断时，是否自动重新连接？不推荐使用该特 性，这是因为，当应用程序不能恰当处理SQLExceptions时，它会造成与会话状态和数据一致性有关的副作用默认值：false（官方不建议开启该属性）。

剩余属性可以参考：

https://blog.csdn.net/chunweizhi4982/article/details/100977705
