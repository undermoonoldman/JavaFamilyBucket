# ***一对多映射***

### **在本例中，一位用户对应多个账户，是一对多关系**

1. ## 为一条一对多查询配置结果集映射

   1. ### 结果集类型为关联前实体类，在本例中则是用户类

   2. ### 配置关联前对应为 “一” 实体类与数据库字段映射，id 指定注解字段，result 指定普通字段

   3. ### 使用 collection 标签配置关联后对应为 “多” 的实体类与数据库字段映射

      1. #### property：配置“一”的实体类中对应“多”的属性的名称

      2. ####ofType：配置“多”的属性中单个实体的类型，用类的全限定名 

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/076.jpg)

1. ## 在对应的 Sql 标签中使用刚才配置的结果集作为 resultMap

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/077.jpg)