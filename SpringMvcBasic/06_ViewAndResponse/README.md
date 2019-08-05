# ***响应数据与视图解析***

1. ## 返回值分类

   1. ### 返回字符串

      1. #### Controller 方法返回字符串可以指定逻辑视图的名称，根据视图解析器解析出物理视图的地址

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/021.jpg)

   2. ### 返回值为 void

      1. #### 在没有手动做重定向或转发的情况下会跳转到与请求 URL 路径相同的视图页面下，如果该视图不存在会报 404 错误

      2. #### 可以手动转发或者重定向到指定的页面(项目名即为视图所在的目录)

         1. ##### 使用 Servlet 原生 API 进行转发(视图解析器不工作，一次请求，不需要写项目名)

            ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/022.jpg)

         2. ##### 使用 Servlet 原生 API 进行重定向(视图解析器不工作，两次请求，需要写项目名)

            ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/023.jpg)

         3. ##### 直接把输出流写回到浏览器(需要解决中文乱码问题)

            ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/024.jpg)

   3. ### 返回值是 ModelAndView 对象(使用该对象进行跳转时视图解析器正常工作)

      1. #### ModelAndView 是 Spring 提供的对象，可以用来携带对象数据并跳转到指定页面

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/025.jpg)

2. ## SpringMvc 框架提供的通过关键字实现的转发与重定向

   1. ### forward 转发

      1. #### Controller 方法返回 String 类型(视图解析器这时不工作，需要写完整路径)

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/026.jpg)

   2. ### redirect 重定向

      1. #### Controller 方法返回 String 类型(可以不写项目名，这点与原生 API 不同)

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/027.jpg)

3. ## ResponseBody 相应 json 数据

   1. ### DispatcherServlet 拦截路径配置为 "/" 会导致所有资源被拦截，包括静态资源(img，css，js)，所以要配置静态资源不被拦截

      1. #### mvc:resources 标签配置不过滤

         1. ##### location 表示 webapp 包下的文件

         2. ##### mapping 表示请求以 "/static" 开头的请求路径

            ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/028.jpg)

   2. ### 使用 RequestBody 获取请求体数据

      1. #### 前端页面提交 ajax 请求

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/029.jpg)

      2. #### 后端使用 @RequestBody 接收请求体数据，把 json 串反序列化为 Java 对象

      3. #### 后端使用 @ResponseBody 把 Java 对象序列化为 json 串返回给前端，直接响应

         1. ##### 需要 Controller 方法的返回值为 Java 对象

            ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/030.jpg)

         2. ##### json 与 Java 对象的互相转换需要导入 jackson 相关的 jar 包

            ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/031.jpg)

