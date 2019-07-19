# *上节简单演示了使用spring容器管理bean的步骤,本节来补充spring容器管理bean的一些细节*

## bean作为对象,就会有创建,生存,销毁等于生命周期相关的阶段,作为Web项目中的Bean自然也会有其作用范围

+ ## bean的创建:

  1. ### 默认构造函数创建:没有默认构造函数时会出错

  2. ### 普通工厂普通方法:因为要使用工厂来创建对象,所以先把工厂作为一个普通bean配置进去,然后配置要创建的对象,通过指定factory-bean为刚才配置的工厂

  3. ### 静态工厂静态方法:静态工厂并不需要把工厂实例化,所以在配置要创建对象时把类指定为静态工厂,并且添加factory-method为静态方法即可

+ ## bean的作用范围:

  1. ### request:请求范围

  2. ### session:会话范围

  3. ### global-session:集群会话,非集群下等同于session

+ ## bean的加载方式:

  1. ### singleton:默认值,单例,读取配置文件时就加载,与容器同生共死

  2. ### prototype:多例,懒加载,使用是才加载,垃圾回收器负责回收

![正事配图](https://github.com/NoMoreThanAWord/SpringFamilyBucket/raw/master/Resource/IMG/002.jpg)

