# ***一对一映射***

### **在本例中，账户表记录与用户表记录是一对一关系**

1. ## 为一条一对一查询配置结果集映射

   1. ### 结果集类型为关联前实体类，在本例中则是账户类

   2. ### 配置关联前实体类与数据库字段映射，id 指定注解字段，result 指定普通字段

   3. ### 使用 association 标签配置关联后实体类与数据库字段映射

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/074.jpg)

1. ## 在对应的 Sql 标签中使用刚才配置的结果集作为 resultMap

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/075.jpg)