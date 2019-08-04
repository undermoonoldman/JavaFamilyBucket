# ***常用注解***

1. ## RequestParam

   1. ### 作用：把请求中指定名称的参数传递给 Controller 中的形参赋值

   2. ### 属性

      1. #### value：请求参数中的名称

      2. #### required：请求参数是否必须提供，默认为 true

   3. ### 示例

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/008.jpg)

2. ## RequestBody

   1. ### 作用：用于获取请求体的内容(get 方法没有请求体)

   2. ### 属性

      1. #### required：是否必须有请求体，默认为 true

   3. ### 示例

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/009.jpg)

3. ## PathVariable

   1. ### 作用：获取 URL 中绑定的占位符。例如：/get/{id}，{id} 即为占位符。需要前端请求路径配置来实现 restful 风格的 URL ，即一套请求路径实现多种功能，根据请求方法来区分

   2. ### 属性

      1. #### value：指定 URL 中占位符的名称

   3. ### 示例

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/010.jpg)

4. ## RequestHeader

   1. ### 作用：获取指定请求头的值

   2. ### 属性

      1. #### value：请求头的名称

   3. ### 示例

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/011.jpg)

5. ## CookieValue

   1. ### 作用：用于获取指定名称 cookie 的值

   2. ### 属性

      1. #### value：cookie 的名称

   3. ### 示例

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/012.jpg)

6. ## ModelAttribute

   1. ### 作用

      1. #### 标注方法：当前方法会在当前 Controller 中所有方法执行之前执行

      2. #### 标注参数：获取指定的数据给参数赋值

   2. ### 应用场景

      1. #### 前台提交的数据封装的对象有字段缺失时， 用来编写业务逻辑把缺失字段在后台补上

   3. ### 示例

      1. #### 标注的方法没有返回值

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/013.jpg)

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/014.jpg)

      2. #### 标注的方法有返回值

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/015.jpg)

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/016.jpg)

7. ## SessionAttributes

   1. ### 作用：用于多次执行 Controller 方法之间的参数共享

      ### 该注解只能标注在类上面

      ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/017.jpg)

   2. ### 属性

      1. #### value：指定存入属性的名称

   3. ### 示例

      1. #### 添加属性

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/018.jpg)

      2. #### 获取属性

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/019.jpg)

      3. #### 删除属性

         ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/020.jpg)

