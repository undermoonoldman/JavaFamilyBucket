# ***用户手动编写 Dao 实现类***

1. ## 创建 Dao 实现类并进行编写

   ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/068.jpg)

   1. ### 利用 SqlSessionFactory 获取 SqlSession

   2. ### 手动开启与关闭 Session

   3. ### 执行数据库操作，通过全限定类名指定使用哪个映射文件中的具体哪个方法

2. ## 编写测试类

   ![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/069.jpg)

   ### 传入 SqlSessionFactory 工厂创建 Dao 实现类，之前是用 SqlSession 创建 Dao 的代理类对象