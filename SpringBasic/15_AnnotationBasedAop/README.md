## **Spring基于注解的AOP使用步骤:**

1. ###在Spring的主配置类上添加注解 @EnableAspectJAutoProx 开启注解AOP

2. ### 使用 @Aspect注解标识当前类是一个切面类

3. ### 使用 @Before, @AfterReturing, @AfterThrowing, @After, @Around 注解标注在切面类的方法上配置当前方法为一个通知,在该标签内写上 excution表达式来表明需要对哪些方法执行增强

4. ### 使用 @Pointcut 注解标注在某无返回值的空方法上标注该方法称为一个切点,可以供其他方法进行使用,方法名称即为切点名

---

---

## ***天坑注意:注解配置的AOP与XML配置的AOP在执行顺序上有所不同,注解配置的AOP执行顺序为 before -> after -> afterReturning,但是注解配置的环绕通知没有执行顺序错乱的问题,所以这里推荐使用环绕通知***

