package com.undermoonoldman.service;


import com.undermoonoldman.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**注解分类
 * 1.创建对象:对应xml中的bean标签
 * @Component:把当前类对象存入Spring容器中
 * 属性:value(用于指定bean的ID,默认为类名首字母小写)
 * 位置:类
 *
 * Controller
 * Service
 * Repository
 *
 * 2.注入数据:对应xml中bean标签中的property标签
 * @Autowired:按照类型注入,如果容器中含有的对象类型唯一匹配,注入成功;多个匹配时,按照变量名称查找bean的ID,匹配则成功注入,如果还无法匹配,报错
 * 位置:成员变量,方法
 *
 * 细节:使用注解注入时,set方法非必须
 *
 * @Qualifier:在按照类型注入基础上再按照名称注入,注入类成员时无法单独使用(需配合@Autowired),注入方法参数时可以单独使用
 * 属性:value,指定注入bean的ID
 *
 * @Resource:直接按照bean的ID注入,可以独立注入
 * 属性:name,指定bean的ID
 *
 * ------------------------------------------------------------------------------
 * 以上三个注解只能注入bean类型,无法注入基本类型与String类型.另外集合类型只能通过xml进行注入
 * ------------------------------------------------------------------------------
 *
 * @Value:用于注入基本类型与String类型的数据
 * 属性:value,指定数据的值,可以使用Spring中的El表达式,${表达式}
 *
 *
 *
 * 3.改变作用范围:对应xml中bean标签的scope标签
 * @Scope:指定bean的作用范围
 * 属性:value,指定范围的取值,常用取值,singleton prototype
 *
 *
 * 4.与生命周期相关的:对应xml中bean标签下的init-method与destory-method标签
 * @PreDestory:指定销毁方法
 * @PostConstruct:指定初始化方法
 * */


/**天坑注意,Java9及以上版本中,部分注解无法正常工作,需要添加"javax.annotation-api"依赖*/


//只有一个属性时,value可以省略
@Component()
public class AccountServiceImpl implements AccountService {

//    @Autowired
//    @Qualifier(value = "accountDaoImpl")
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @PostConstruct
    public void init(){
        System.out.println("service init method!");
    }

    @PreDestroy
    public void destory(){
        System.out.println("service destory method!");
    }

    public AccountServiceImpl() {
        System.out.println("创建Service对象!");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
