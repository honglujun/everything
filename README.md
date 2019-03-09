# everything
学习springcloud的demo

## 项目技术使用说明
```
环境配置：
    JDK：1.8
    maven：apache-maven-3.5.4
项目的框架使用的版本：(按spring官方文档来的)
    持久层框架：MyBatis、通用Mapper4、Mybatis_PageHelper
    数据库连接池：Alibaba Druid
    
    springcloud：Finchley.SR2
    springboot：2.0.6.RELEASE
    spring-cloud-netflix：2.0.2.RELEASE（包含了Eureka,Hystrix,Ribbon,Zuul）
    spring-cloud-bus: 2.0.0.RELEASE
    spring-cloud-config: 2.0.2.RELEASE
    spring-cloud-gateway: 2.0.2.RELEASE
    
```

## 项目结构说明
```
├─everything----------------------------项目的外壳，就是为了方便的在一个idea中打开，一次加载maven项目，项目中没有具体的作用，可以不用
│  │
│  ├─everything-api-gateway-------------------微服务网关
│  │
│  ├─everything-common------------------------微服务公共部分
│  │
│  ├─everything-config------------------------微服务配置中心(以后用Apollo试试)
│  │
│  ├─everything-eureka------------------------微服务注册中心
│  │
│  ├─everything-product-----------------------微服务一(没想好做什么)
│  │
│  ├─everything-order-------------------------微服务二(使用了elasticsearch搜索，做了一个demo。还用了jfreechart做了图表生成)
│  │
│  ├─everything-demo--------------------------微服务demo项目，没什么用，就是一些依赖在pom文件里面可以直接copy
│  │
│  ├─everything-------------------------------微服务三(以后想清楚做什么再补充)
│  │
│  ├─everything-------------------------------微服务四
│  │
│  ├─everything-------------------------------微服务五
```
##  项目中的结构说明
```
feign：
微服务之间调用用feign。feign中引用了Ribbon可以做到负载均衡。
微服务中的api包中的controller是给的其他微服务的feign调用的。
在这个例子中，product微服务的API是给order微服务中的feign包中的接口调用的（order微服务的feign接口上的URI跟product中的API包中的URI要一致），
feign中的实现是用来做服务降级的。

```
