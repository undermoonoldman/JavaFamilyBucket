## **基于子类的动态代理:涉及的类Proxy,提供者第三方cglib库**

+ ### 前提:存在一个被代理类,无需提供被代理接口

+ ### 我们需要做的是使用cglib提供的Enhancer类中的create方法创建代理对象并实现函数参数之一的intercept方法

+ ### 使用步骤:

  1. ##### 调用Enhancer类的create方法创建一个代理类对象

     ##### 需要参数有:被代理类字节码(固定写法),匿名内部类MethodIntercepter(需要我们自己来编写)

  2. ##### 编写匿名内部类MethodIntercepter,主要是编写intercept方法

     ##### intercept方法参数:o(代理对象的引用),method(当前被代理对象执行的方法,可以根据方法名对不同的方法添加不同的逻辑,完成增强逻辑后调用method的invoke方法执行被代理对象本来的逻辑),objects(当前执行方法所需的参数),以上三个参数与invoke方法的参数是一致的,methodProxy(当前执行方法的代理对象,很难用得上)

