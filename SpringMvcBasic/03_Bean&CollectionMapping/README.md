# ***请求参数绑定***

1. ## 请求参数绑定机制的说明

   1. ### 绑定机制

      + #### 表单提交数据是 key，value 格式的，比如 username=laowang&password=123

      + #### SpringMvc 的参数绑定是把表单提交的参数请求，作为控制器中方法的参数进行绑定的

      + #### 要求：提交表单的name与参数的名称是相同的

   2. ### 支持的数据类型

      + #### 基本数据类型与字符串类型

      + #### 实体对象(JavaBean)

      + #### 集合类型(List，Map集合等)

2. ## 基本类型与字符串类型

   1. ### 提价表单的 name 与参数名称是相同的

   2. ### 大小写是区分的

3. ## 实体对象类型(JavaBean)

   1. #### 表单的 name 与 JavaBean 中的属性名称要一致

   2. #### 如果一个 JavaBean 类中包含其他的引用类型，表单的 name 属性要编写成：对象.属性，例如：person.name

4. ## 集合类型

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/003.jpg)

5. ## 解决请求参数中文乱码问题

   1. ### post 请求：在 web.xml 中配置 Spring 提供的过滤器

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/004.jpg)

   2. ### get 请求：在 Tomcat 的配置文件 server.xml 中的 <connector> 标签中加一个属性 URIEncoding = "UTF-8"