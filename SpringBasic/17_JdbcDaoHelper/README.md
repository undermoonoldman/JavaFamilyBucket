### 其实Spring中有JdbcTemplate了,在使用是不用自己做实现.使用接口的方式可以方便加注解,而继承因为了JdbcDaoSupport所以不用在引入JdbcTemplate了,但是同样的也失去了注解开发的能力,只能使用XML来进行配置

### 如果使用XML配置,推荐使用继承。如果使用注解配置,推荐使用接口实现。

