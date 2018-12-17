# everything
学习springcloud的demo

##项目技术使用说明
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

##项目结构说明
```
├─everything----------------------------项目的外壳，就是为了方便的在一个idea中打开，一次加载maven项目，项目中没有具体的作用，可以不用
│  │
│  ├─everything-eureka------------------------微服务注册中心
│  │
│  ├─everything-product-----------------------微服务一(没想好做什么)
│  │
│  ├─everything-order-------------------------微服务二(没想好做什么)
│  │
│  ├─everything-api-getway--------------------微服务网关
│  │
│  ├─everything-config------------------------微服务配置中心(以后用Apollo试试)
│  │
│  ├─everything-------------------------------微服务三(以后想清楚做什么再补充)
│  │
│  ├─everything-------------------------------微服务四
│  │
│  ├─everything-------------------------------微服务五
```
##
