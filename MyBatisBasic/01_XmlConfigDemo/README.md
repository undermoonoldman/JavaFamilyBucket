# ***基于 Xml 配置的入门小案例***

1. ## 导入坐标

   ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/057.jpg)

2. ## 建库，建表

3. ## 参照之前建立的数据库，按照 maven 的包结构规范，创建对应的实体类

4. ## 创建 UserDao 接口，编写好参数与返回类型，不用写实现类，MyBatis 会根据我们编写的 Sql 与对应接口生成实现类

5. ## 在 resource 文件下编写 MyBatis 配置文件 SqlMapConfig.xml

   1. ### 约束头

   2. ### 环境配置

      1. #### MySQL

      2. #### 事务类型

      3. #### 数据源

   3. ### 指定映射配置文件的位置

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/058.jpg)

6. ## 在 resource 文件夹下创建与 Dao 层相同的包结构，在 Dao 包下创建 UserDao.xml 的映射文件并进行编写

   1. ### 约束头

   2. ### 命名空间要求为 Dao 接口的全限定类名

   3. ### Sql 的 ID 属性为对应 Dao 的方法名

   4. ### 映射文件与 Dao 包结构相同

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/059.jpg)

7. ## 编写测试类

   1. ### 读取配置文件

   2. ### 用读入的配置文件创建 SqlSessionFactory

   3. ### 使用工厂生产一个 SqlSession 对象

   4. ### 使用 SqlSession 创建 Dao 接口的代理对象

   5. ### 使用代理对象执行方法

   6. ### 组合释放资源

      ![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/060.jpg)

      