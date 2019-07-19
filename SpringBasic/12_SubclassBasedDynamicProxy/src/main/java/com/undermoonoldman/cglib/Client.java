package com.undermoonoldman.cglib;

import com.undermoonoldman.cglib.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //被代理对象
        final Producer producer = new Producer();

        /**动态代理:在不修改源码的基础上对方法进行增强
         * 分类: 1.基于接口的 ; 2.基于子类的
         *
         * 基于子类
         * 涉及的类:Proxy
         * 提供者:第三方cglib库
         *
         * 创建代理对象:使用Ehancer类中的 create方法
         * 要求:被代理类不能是最终类
         * 参数:
         *      Class:被代理对象的字节码,与被代理对象使用相同的加载器.固定写法
         *      Callback:提供增强代码,让用户编写如何代理,一般写接口实现类,通常为匿名内部类
         *              此接口实现类谁用谁写,一般写该接口子接口的实现类:MethodIntercepter*/

        //代理接口
        Producer proxyProducer = (Producer) Enhancer.create(Producer.class, new MethodInterceptor() {
            /**
             * @param o       代理对象的引用
             * @param method  表示当前执行的方法
             * @param objects 当前执行的方法所需的参数
             *
             * 以上三个参数与基于接口的动态代理中的invoke方法的参数是一致的
             *
             * @param methodProxy 当前执行方法的代理对象
             * @return 与被代理对象具有相同的返回值
             * @throws Throwable
            **/
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                //提供前置增强

                //获取方法执行参数
                Float money = (Float) objects[0];

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
