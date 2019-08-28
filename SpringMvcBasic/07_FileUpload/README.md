# ***SpringMvc 实现文件上传***

1. ## 文件上传的准备工作

   1. ### 导入相关的 jar 包

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/032.jpg)

   2. ### 使用 post 表单进行上传，并修改表单的正文请求类型 enctype 选项为 multipart/form-data

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/033.jpg)

2. ## 传统的文件上传方式

   1. ### 从容器上下文中获取文件上传目录

   2. ### 以上传目录创建 File 对象并创建上传目录路径的文件夹

   3. ### 创建磁盘文件项工厂，并以该工厂创建文件上传对象

   4. ### 文件上传对象解析请求上传文件项列表

   5. ### 遍历文件项列表，区分出是普通字段还是上传的文件项

   6. ### 从文件项获取文件名称，对每个上传的文件项分别执行写入操作，写入路径就是之前创建的 File 对象

   7. ### 传统上传方式会产生临时文件，最后对临时文件做删除操作

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/034.jpg)

3. ## SpringMvc方式文件上传

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/039.bmp)

   ### SpringMvc 提供的 MutipartFile 对象，表示上传的文件，要求改对象名称要与表单 file 标签的 name 保持一致

   ### **前期准备，在 SpringMvc 配置文件中配置文件解析器对象。文件解析器会代我们完成解析并把结果封装到 MutipartFile 对象中**

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/035.jpg)

   1. ### 同上

   2. ### 同上

   3. ### 从 MutipartFile 对象获取文件名称，并用该对象做上传，写入路径同上

   4. ### ~~删除临时文件(并不需要了)~~

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/036.jpg)

4. ## SpringMvc 跨服务器文件上传

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/040.bmp)

   + ### 这里需要准备两台服务器，一台图片服务器，一台应用服务器

   + ### 应用服务器接收用户请求数据，并把用户上传的文件转存到图片服务器上

   + ### 图片服务器运行在本地 9090 端口上，应用服务器运行在本地 8080 端口上

   + ### 还需导入跨服务器上传相关的 jar 包

     ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/037.jpg)

   1. ### 定义图片服务器的请求路径(要确保图片服务器上传图片的文件夹存在)

   2. ### 同上，获取文件名

   3. ### 创建客户端对象

   4. ### 使用客户端连接图片服务器(需要填写服务器路径与上传文件名称拼接成的最终路径)

   5. ### 上传文件

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/038.jpg)