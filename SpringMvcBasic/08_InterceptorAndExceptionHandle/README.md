# ***SpringMvc异常处理***

1. ## 异常处理思路流程

   ### Controller 调用 Service，Service 调用 Dao，异常都是向上层抛出，最终由 DispatcherServlet 找到相关的异常处理器进行异常的处理

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/041.bmp)

2. ## 配置SpringMvc 的异常处理步骤

   1. ### 编写自定义异常类

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/042.jpg)

   2. ### 编写自定义异常处理器

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/043.jpg)

   3. ### 把自定义异常处理配置到 Spring 容器中，就像一个普通的 Bean 一样

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/044.jpg)

# ***SpringMvc 中的拦截器***

1. ## 关于拦截器

   1. ### SpringMvc 框架中的拦截器用于对 Controller 进行预处理后处理与终处理

   2. ### 过滤器是 Servlet 的技术，而拦截器是 SpringMvc 的技术

   3. ### 过滤器可以拦截所有资源而拦截器只能拦截对 Controller 的请求

   4. ### 对同一个方法进行拦截的拦截器可以成链，执行顺序按照拦截器的注册顺序

   5. ### 拦截器是 AOP 的思想实践，自定义拦截器需要实现 HandlerInterceptor 接口

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/045.bmp)

2. ## 配置 SpringMvc 自定义拦截器步骤

   1. ### 编写自定义拦截器，实现 HandlerInterceptor 接口并重写需要的方法

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/046.jpg)

   2. ### 在 springmvc.xml 中配置拦截器(拦截路径与拦截器类)

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/047.jpg)

3. ## 单个拦截器中所有方法的执行顺序

   1. ### preHandle 在 Controller 执行前进行拦截

      1. #### 可以进行转发或重定向来执行页面跳转

      2. #### return true 放行，执行下一个拦截器，直到执行 Controller 方法

      3. #### return false 不放行，不会执行 Controller 方法

   2. ### postHandle 在 Controller 执行后视图执行之前做拦截

      1. #### 可以进行转发或重定向来执行页面跳转

      2. #### 执行页面跳转后，Contoller 中跳转的页面不会显示

   3. ### afterCompletion 在视图渲染后执行，此时执行页面跳转无效了

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/048.jpg)

4. ## 单个拦截器前置拦截不放行并进行跳转

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/052.jpg)

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/049.jpg)

5. ## 单个拦截器后置拦截并进行跳转

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/053.jpg)

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/050.jpg)

6. ## 两个拦截器组成的拦截器链的执行顺序

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/054.jpg)

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/055.jpg)

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/056.jpg)

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/051.jpg)