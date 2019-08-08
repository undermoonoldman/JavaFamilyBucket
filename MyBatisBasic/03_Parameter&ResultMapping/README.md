# ***查询参数与查询结果映射***

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/064.jpg)

1. ## 查询参数类型

   1. ### 普通类型与字符串

      #### 可以使用 #{参数名} 的方式在 Sql 中调用，只有单个参数是，参数名不重要。

   2. ### 普通对象类型

      #### 可以用全限定类名指定，在 Sql 中使用 #{属性名} 来调用对象中的属性

   3. ## 嵌套对象类型

      ### 嵌套对象类型在 Sql 中使用 #{内嵌对象名.内嵌对象属性名} 来调用内嵌对象的属性名称

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/066.jpg)

2. ## 查询结果类型

   1. ### 普通类型与字符串

   2. ### 对象类型(返回对象集合与单个对象的设置相同)

   ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/065.jpg)

3. ## 也可以使用 resultMap 标签把对象与数据库表字段的映射做预先定义，方便之后使用

   ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/067.jpg)