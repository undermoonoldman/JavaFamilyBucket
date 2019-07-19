## **前期准备:本次把数据源相关的信息配置在了一个JdbcConfig类中,并没有在XML中进行配置,并使用${属性值}的方式从类路径下的properties文件中读取需要的数据源相关信息。**



## 采用纯注解的配置(没有XML)需要编写一个主配置类,并在其上面加上 @Configuration 表明这是一个配置。如果配置类有多个,其他子配置类并不需要加上注解,只需要在主配置类中使用 @Import注解导入子配置类即可,可以一次导入多个子配置类。@PropertySource 注解可以指定properties文件的位置。@Componetscan 注解开启包扫描



## Spring没有整合Junit时,使用Junit进行单元测试要手动创建Spring的IOC容器,十分的不方便



---

---

## 注意:在使用Spring5版本时,Junit版本至少应为4.1.2以上



## Spring整合Junit步骤:

1. ### 导入相应的坐标: spring-test

2. ### 在测试类上添加 @RunWith(SpringJUnit4ClassRunner.class)

3. ### 告知Spring运行器,spring与IOC是基于xml还是注解的,并且说明注解的位置

   #### @ContextConfiguration:locations:指定xml文件的位置,加上classpath关键字,表示在类路径下。classes:指定注解类所在的位置

