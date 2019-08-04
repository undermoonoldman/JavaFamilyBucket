# ***RequestMapping 注解***

1. ## RequestMapping 注解的作用是建立请求 URL 和处理方法之间的对应关系

2. ## RequestMapping 注解可以作用在方法与类上面

   1. ### 作用在类上：访问的一级目录

   2. ### 作用在方法上：访问的二级目录

   3. ### 细节：路径可以不写，/ 表示从跟路径开始

   4. ### 细节：$(pageContext.request.contextPath)可以省略不写，但路径上不能写 /

3. ## RequestMapping的属性

   1. ### path：请求路径的 URL(默认属性)

   2. ### value：value 属性与path 属性的作用是相同的

   3. ### method：指定方法的请求方式

   4. ### params：指定限定请求的参数条件

   5. ### headers：指定发送请求中必须包含的请求头