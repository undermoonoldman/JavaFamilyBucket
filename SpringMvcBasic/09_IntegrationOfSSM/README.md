# ***Spring 整合 SpringMvc 与 MyBatis***

---

## ***Spring 配置***

---



1. ## applicationContext.xml 配置文件作为 Spring 的配置文件

   + ### Spring 配置包扫描，但是要把 Controller 排查在外，交由 SpringMvc管理

---

## ***SpringMvc 配置***

---



1. ## 在 Web 项目的配置文件 web.xml 中配置前端控制器 DispatcherServlet

   + ### 配置前端控制器拦截 "/" 路径

   + ### 配置为启动加载

   + ### 并把 SpringMvc 的配置文件 springmvc.xml 配置到前端控制器的初始化参数里面去

2. ## 在 web.xml 中配置过滤器解决中文乱码问题

   + ### 注册过滤器

   + ### 配置编码方式为 "UTF-8" 的初始化参数

   + ### 配置过滤器拦截路径为所有路径 "/*"

3. ## 编写 springmvc.xml 配置文件

   + ### 根据业务需求导入相关约束，通常最小量是 bean，mvc，context

   + ### 开启包扫描，只扫描 Controller

   + ### 配置视图解析器

   + ### 配置静态资源不过滤

   + ### 开启 SpringMvc 注解支持(很重要)

---

## ***Spring 整合 SpringMvc***

---



1. ## 在 web.xml 中配置 ContextLoaderListener 监听器用来在容器加载时把 Spring 配置文件也加载进来

   + ### 注册监听器

   + ### 配置类路径下的需要加载的配置文件(application.xml)

2. ## 在 Controller(SpringMvc 管理) 中注入 Service(Spring 管理)

---

## ***MyBatis 配置(注解方式)***

---



1. ## 在 web 项目中创建并编写 SqlMapConfig.xml 的配置文件

   + ### 约束，环境，Dao 接口所在的包或具体类

2. ## 在对应的 Dao 接口类的方法上添加注解并编写 SQL 语句

---

## ***Spring 整合 MyBatis***

---



1. ## 把 MyBatis 的配置文件SqlMapConfig.xml中内容配置到 Spring 的配置文件applicationContext.xml中去

   + ### C3P0 数据库连接池

   + ### SqlSession工厂

   + ### 通过配置 MapperScanner 来指定要扫描的 Dao 包

2. ## 在 Dao 类上加 @Repository 注解交给 Spring 来管理

3. ## 在 Service 中注入 Dao

