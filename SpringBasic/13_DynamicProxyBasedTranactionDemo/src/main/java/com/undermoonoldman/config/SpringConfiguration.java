package com.undermoonoldman.config;

import com.undermoonoldman.factory.BeanFactory;
import com.undermoonoldman.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;


/**配置类注解,用来在Spring中完全替代XML
 * @Configuration:指定当前类是一个配置类
 * 细节:当配置类作为AnnotationConfigApplicationContext对象创建的参数时,该注解可以省略
 *
 * @Componentscan:指定Spring创建容器时要扫描的包
 * 属性:basePackages与value作用相同,都是指定扫描包,等同于 <context:component-scan base-package="com.undermoonoldman"></context:component-scan>
 *
 * @Bean:把当前方法的返回值作为bean对象存入IOC容器中
 * 属性:name,用于指定bean的ID,默认为当前方法的名称
 *
 * 细节:使用注解配置方法时,Spring会到IOC容器中去匹配方法参数,就像@Autowired注解一样
 *
 * @Import:用于导入其他配置类,比如在一个总配置类下面导入多个子配置类
 * 属性:value,用于指定其他配置类的字节码,有Import注解的为父配置类,导入的都是子配置类
 *
 * @PropertySources
 * @PropertySource:指定properties文件的位置
 * 属性:value,指定文件名称与路径
 * 关键字:classpath,表示在类路径下
 * */

@Configuration
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
