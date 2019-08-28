# ***一对多懒加载***

### **在本例中，用户表记录与账户表记录是一对多关系**

1. ## 为一条一对多查询配置结果集映射

   1. ### 结果集类型为关联前实体类，在本例中则是账户类

   2. ### 配置关联前实体类与数据库字段映射，id 指定注解字段，result 指定普通字段

   3. ### 使用 collection 标签配置关联后实体类与数据库字段映射

      1. #### column：唯一查询关联后实体所需要参数的值，本例中为 uid，即账户表中的用户 id 字段

      2. #### ofType：关联后的实体类，用全限定类名

      3. #### select：指定用于唯一查询所使用的 Dao 类中的方法

![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/085.jpg)

2. ## 在对应的 Sql 标签中使用刚才配置的结果集作为 resultMap

![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/086.jpg)

2. ## 还需要在 MyBatis 主配置文件 SqlMapConfig.xml 中配置开启延迟加载全局开关

![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/082.jpg)

