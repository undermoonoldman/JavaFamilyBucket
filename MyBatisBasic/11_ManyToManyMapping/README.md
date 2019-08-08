# ***多对多映射***

### **在本例中，一位用户对应多个角色，同时一个角色也对应多个用户，这是多对多关系**

1. ## 为两条多对多查询配置结果集映射，用户角色配一个，角色用户也配一个

   1. ### 结果集类型为关联前实体类

   2. ### 配置关联前实体类与数据库字段映射，id 指定注解字段，result 指定普通字段

   3. ### 使用 collection 标签配置关联后实体类与数据库字段映射

      1. #### property：配置实体类中对应“多”的属性的名称

      2. #### ofType：配置“多”的属性中单个实体的类型，用类的全限定名 

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/078.jpg)

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/079.jpg)

1. ## 在对应的 Sql 标签中使用刚才配置的结果集作为 resultMap

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/081.jpg)

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/081.jpg)