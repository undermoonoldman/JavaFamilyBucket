## **前期准备:配置c3p0数据源,配置queryRunner,注意在同一个queryRunner下执行的sql会被判断为一个事务,所以如果不同的dao使用同一个queryRunner的话会产生意料之外的结果,故这里queryRunner不能配置为单例的,应该配置为多例,让不同的dao来使用不同的queryRunner**

## **配置相应的bean:在使用XML没有开启包扫描的情况下,要把需要的dao与service的实现类配置到文件里去**

