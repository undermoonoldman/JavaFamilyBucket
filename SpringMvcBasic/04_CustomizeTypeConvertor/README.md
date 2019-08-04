# ***自定义类型转换器***

1. ## 表单提交的所有数据类型全部都是字符串，但是在后台定义 Integer 类型数据却可以正常封装，说明 Spring 框架内部做了默认的数据类型转换

2. ## 如果要自定义数据类型转换，可以实现 Converter 的接口

   1. ### 自定义类型转换器，编写 convert 方法

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/005.jpg)

   2. ### 在 springmvc.xml 中编写配置，注册刚才定义的类型转换器

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/006.jpg)
      
      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/007.jpg)

3. ## 在 Controller 中使用原生的 ServletAPI 对象

   ### 在Controller 的方法参数定义 HttpServletRequest 与 HttpServletResponse 对象即可

   

