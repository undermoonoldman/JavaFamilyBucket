package com.undermoonoldman.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BeanFactory {
    //把外部配置文件加载进来的存放位置
    private static Properties properties;

    //存放创建出对象的容器,索引是对象的别名
    public static Map<String, Object> beans;

    //静态块,确保读入配置文件与创建所需对象并装入容器的过程在BeanFactory类在被加载时就发生
    static {
        try {
            //从类路径下加载外部配置文件进输入流
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties = new Properties();
            //读入输入流
            properties.load(inputStream);
            beans = new HashMap<String, Object>();

            //用枚举对象取出所有要创建对象的别名作为在容器中查找对象的索引
            Enumeration keys = properties.keys();

            //利用反射创建所有的对象并存入容器中,索引为对象的别名
            while(keys.hasMoreElements()){
                String name = (String)keys.nextElement();
                beans.put(name, createBean(name));
            }

        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化配置文件失败");
        }
    }

    //以对象别名找到全类名创建生成对象并返回
    private static Object createBean(String beanName){
        Object bean = null;

        try {
            //以别名获取对象的全类名
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;      
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
