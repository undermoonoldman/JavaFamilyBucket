package com.undermoonoldman.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //被代理对象
        final ProducerImpl producer = new ProducerImpl();

        /**动态代理:在不修改源码的基础上对方法进行增强
         * 分类: 1.基于接口的 ; 2.基于子类的
         *
         * 基于接口
         * 涉及的类:Proxy
         * 提供者:JDK官方
         *
         * 创建代理对象:使用Proxy类中的 new ProxyInstance()方法
         * 要求:被代理类最少实现一个接口,否则无法使用
         * 参数:
         *      Classloader:加载代理对象字节码,与被代理对象使用相同的加载器.固定写法
         *      Class[]:字节码数组,让代理对象与被代理对象有相同的方法.固定写法
         *      InvocationHandler:提供增强代码,让用户编写如何代理,一般写接口实现类,通常为匿名内部类*/

        //代理对象,必须要实现接口才能使用
        ProducerImpl proxyProducer = (ProducerImpl) Proxy.newProxyInstance(ProducerImpl.class.getClassLoader(), ProducerImpl.class.getInterfaces(), new InvocationHandler() {
            /**执行被代理对象的任何接口方法都会经过该方法
             * @param proxy 代理对象的引用
             * @param method 表示当前执行的方法
             * @param args 当前执行的方法所需的参数
             * @return 与被代理对象方法有相同的返回值
             * @throws Throwable*/
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                //提供前置增强

                //获取方法执行参数
                Float money = (Float) args[0];

                //判断方法名称
                if("saleProduct".equals(method.getName())){
                    System.out.println("扣除成本");
                    returnValue = method.invoke(producer, money * 0.8f);
                }

                return returnValue;
            }
        });

        Float money = 10000f;

        proxyProducer.saleProduct(money);
    }
}
