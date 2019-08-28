# ***基于注解的一对多映射***

### 本例中用户与账户是一对多关系

1. ## 同样使用 @Results 注解配置结果集映射

2. ## @Result 配置关联属性

   1. ### property：所关联的实体类名称，本例中为 accounts

   2. ### uid：用于唯一确定关联实体类的属性，本例中为 id

   3. ### Many：配置一对多关联

      1. #### select：配置用于查找关联实体类的 Dao 中的方法

      2. #### fetchType：配置是否懒加载，FetchType.EAGER 开启懒加载

![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/091.jpg)