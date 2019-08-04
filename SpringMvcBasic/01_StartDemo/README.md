# ***SpringMvc入门Demo***

1. ## 编写入门案例

   1. ### 导入坐标

   2. ### 在web.xml 中配置核心控制器 DispathcerServlet

      + #### 注册 servlet

      + #### 配置 servlet 初始化参数，读取 springmvc 配置文件，创建spring容器

      + #### 配置为容器启动时加载

      + #### 配置映射 url

   3. ### 编写springmvc.xml 配置文件

      + #### 导入相应的约束，bean，mvc，context

      + #### 配置包扫描

      + #### 配置视图解析器(配置 prefix 与 suffix)

   4. ### 编写 index.jsp 与 HelloController 类

   5. ### 在 WEB-INF 目录下创建 pages 文件夹，并编写 success.jsp 的成功相应页面

   6. ### 启动 Tomcat

2. ## 入门案例执行过程分析

   1. ### 入门案例执行流程

      1. #### 启动容器时，由于配置了随容器加载而创建的属性，所以会创建 DispatcherServlet对象，并且加载 springmvc.xml 配置文件

      2. #### 由于开启了注解扫描，配置了注解的 HelloController 就会被创建

      3. #### 从 index.jsp 发出请求，请求会先到达 DispatcherServlet 核心控制器，根据 @RequestMapping 注解找到具体的执行方法

      4. #### 根据方法的返回值，与配置的视图解析器，到指定目录下去查找指定名称的 jsp 文件

      5. #### Tomcat 服务器渲染页面，作出相应

   2. ### 入门案例中用到的组件

      1. #### 前端控制器 DispatcherServlet

      2. #### 处理器映射器 HandlerMapping

      3. ### 处理器 Handler

      4. #### 处理器适配器 HandlerAdapter

      5. #### 视图解析器 ViewResolver

      6. #### 视图 View

         

