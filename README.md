<h1 align="center">
  SpringBoot 整合各类框架和应用
</h1>

<p align="center">
	<strong>所有代码都通过测试，并且真实有效</strong>
</p>

<p align="center">
  <a target="_blank" href="https://github.com/intomylife/SpringBoot">
    <img src="https://img.shields.io/github/stars/intomylife/SpringBoot.svg?style=social" alt="github star"/>
  </a>&ensp;
  <a target="_blank" href="https://github.com/intomylife/SpringBoot">
    <img src="https://img.shields.io/github/forks/intomylife/SpringBoot.svg?style=social" alt="github fork"/>
  </a>&ensp;
  <img src="https://img.shields.io/badge/real%20stuff-Max-red" alt="real stuff - Max"/>
</p>

------

### 简介

本仓库整合了一些工作中经常用到的一些技术。目前深度较浅，但会持续更新，并且会慢慢加深。

### 文档

* 数据库相关

    * [SpringBoot 整合 MyBatis-Plus](https://blog.csdn.net/qq_41402200/article/details/88891511)

    * [SpringBoot 整合 Redis](https://blog.csdn.net/qq_41402200/article/details/88952520)

    * [SpringBoot 整合 MongoDB](https://blog.csdn.net/qq_41402200/article/details/89018869)

    * [SpringBoot 整合 Flyway](https://blog.csdn.net/qq_41402200/article/details/89247317)

* 中间件相关

    * [SpringBoot 整合 Dubbo](https://blog.csdn.net/qq_41402200/article/details/89072962)

    * [SpringBoot 整合 ActiveMQ](https://blog.csdn.net/qq_41402200/article/details/89144897)

    * [SpringBoot 整合 Kafka](https://blog.csdn.net/qq_41402200/article/details/89432711)

* 定时任务相关

    * [SpringBoot - Scheduling](https://blog.csdn.net/qq_41402200/article/details/89352147)

* API 文档相关

    * [SpringBoot 整合 Swagger](https://blog.csdn.net/qq_41402200/article/details/89280513)

* ...

### 对于项目结构的一些说明

#### 前言

有朋友说出了一些疑问：

> 为什么有些工程里没有任何代码，是有什么特别的用途或者意义吗？

我的回答是：

> 可以看出，所有的相关整合我都是用的一种结构，这种结构其实是可以适用于 **Dubbo** 和 **微服务** 架构的，也是出于习惯，即使有些单个的技术点可能只需用到一两个类文件，我也是“不厌其烦”，更或者说是想保持一种统一的风格，就还是把所有的目录结构全部新建上去。

不过，最近我发现了一个很尴尬的事情：

> 原来提交代码的时候，Git 自动把空目录过滤了！也就是空目录压根没有提交上来，内心瞬间“五味杂陈”（笑 cry）。瞬间想到，原来问我的是：大兄弟提交的空目录是干啥的？随后我花了一天的时间把所有的空目录补回来了：[48eaf58](https://github.com/intomylife/SpringBoot/commit/48eaf5824d136ee32de30c39510724f1ea5cbccb)，[8023f4a](https://github.com/intomylife/SpringBoot/commit/8023f4a14b56b42495942a925b44edfa77a08d05)，[240335a](https://github.com/intomylife/SpringBoot/commit/240335a9f9206568d829a73c669280713b8f7d4a)，[6ed2fa7](https://github.com/intomylife/SpringBoot/commit/6ed2fa7b5af85fdbf5d173a183aef0238a999c69)，[23c90c3](https://github.com/intomylife/SpringBoot/commit/23c90c34b64676b878b470288b9507a89b444914)，[1b1309e](https://github.com/intomylife/SpringBoot/commit/1b1309ec88a4cd308d1ba1d60aa1498f82d18ded)，[630e879](https://github.com/intomylife/SpringBoot/commit/630e87936066fb0a6adbc3b57e1f586c871f8a2f)，[9e2376a](https://github.com/intomylife/SpringBoot/commit/9e2376acd5bdeff1c382cd6e649d83c94f19dfab)，[6a90702](https://github.com/intomylife/SpringBoot/commit/6a90702fc74306b30bd316296ca17b8f2416a3b0)

#### 结构

最外层目录：

* xxx-commons：公用工程，用来引入公共的依赖，编写默认初始的配置信息，对应的工具类，以及统一返回实体类等等能抽取出来的一切公用代码。比如当项目中需要使用`Redis`做缓存，这时首先会在此工程中引入`Redis`的依赖`spring-boot-starter-data-redis`；其次编写`Redis`默认的最大连接数，连接超时时间等这些配置信息；然后考虑到兼容还需要统一解决序列化问题；最后把一些频繁使用的`Redis`操作封装到工具类中来简化调用。

* xxx-service：聚合服务工程，用来指定`SpringBoot`版本信息，配置部署信息，以及包含所需的所有子模块。也就是说这个父工程是没有其他代码的，主要就只有一个`pom.xml`文件。

xxx-service：

* 包含各种模块，比如**用户模块**，**订单模块**等等

* 从当前的 [SpringBoot 整合各类框架和应用](https://github.com/intomylife/SpringBoot) 中的服务之间调用使用`Dubbo`，到后来的 [简单了解微服务](https://github.com/intomylife/SpringCloud) 中的服务之间调用使用`服务注册与发现`，项目结构都是 **xxx-commons** + **xxx-service**

xxx-service-api：

* 每个模块中的“接口”工程

* 使用`Dubbo`技术调用服务时，需要先把对外提供的接口在内部实现了，然后再对外暴露并被引入到调用者的工程中，这时为了解耦合，会只把对外暴露的接口单独写在一个工程里，也就是当前的 **xxx-service-api** 工程；在 [SpringBoot 整合各类框架和应用](https://github.com/intomylife/SpringBoot) 中对应的目录结构如下

```
 - api              ## 对外暴露的接口
 - constant         ## 常量
 - dto              ## 扩展实体类
```

* 使用`服务注册与发现`技术调用服务时，而是使用的 **服务名** + **请求的完整签名** 来实现的，所以到 [简单了解微服务](https://github.com/intomylife/SpringCloud) 时目录结构变成了这样

```
 - constant         ## 常量
 - dto              ## 扩展实体类
```

xxx-service-core：

* 每个模块的“核心”工程

* 而此时两种架构的基础结构都有如下

```
 - controller       ## 前端控制器
 - domain           ## 基础实体类
 - mapper           ## mapper 接口
    - xml           ## mapper.xml 文件
 - service          ## 处理业务逻辑
```

* 如果是使用`Dubbo`技术，那么，要在自己内部实现对外暴露的接口，所有就有

```
 - api              ## 这里与 xxx-service-api 工程的包名统一
    - impl          ## 对外暴露接口的实现类
```

* 如果是使用`服务注册与发现`技术，那么，写远程调用的类就在

```
 - feign        ## 远程调用
    - fallback  ## 熔断方法
```

* 甚至，使用`服务注册与发现`技术时，可能还会把给其他服务调用的方法专门放在一个统一的包下管理

```
 - api          ## 被其他服务远程调用
```

其他：

可能之前有些项目结构不是和上面所描述的一致，但是现在开始往后的都会以这个为标准来搭建

### 联系我

> 如果您有任何疑问，或者有宝贵的建议，欢迎提交 [issues](https://github.com/intomylife/SpringBoot/issues)。

或通过如下方式联系我：

* Email: intomylife@foxmail.com

### 关于我

* 个人博客：https://www.zouwencong.com

* CSDN：https://blog.csdn.net/qq_41402200
