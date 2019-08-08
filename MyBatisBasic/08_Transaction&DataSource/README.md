# ***配置数据源与事务***

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/073.jpg)

1. ## transactionManager 配置事务管理器

2. ## dataSource 配置数据源

   + ### type：三种取值,POOLED,UNPOOLED,JNDI

     + #### POOLED：传统javax.sql.datasource规范,mybatis有针对的实现

     + ####UNPOOLED：传统获取连接方式,同样实现javax.sql.datasource,未使用连接池的结构,每次获取新连接 

     + #### JNDI：采用服务器提供的JNDI技术实现,获取DataSource对象,不同服务器拿到的对象不同,非web或maven的war是无法使用的