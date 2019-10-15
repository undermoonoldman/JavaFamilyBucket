# ***线程安全策略***

1. ## 不可变对象(使用不可变对象隔绝了并发写场景，所以是线程安全的)

   + ### 不可变对象需要满足的条件

     - #### 对象创建以后其状态就不能修改

     - #### 对象所有域都是final类型

     - #### 对象正确创建(创建期间，this引用没有逸出)

   1. ### 使用final关键字创建不可变对象(final关键字可以修饰类，方法，变量)

      + #### 修饰类 : 不能被继承

      + #### 修饰方法 : 1. 锁定方法使其不能被继承类修改 ; 2. 提升执行效率(老版本，新版本基本已经无差别)

      + #### 修饰变量 : 基本数据类型变量(不允许修改值) ; 引用类型变量(不允许修改指向，可以修改值，修改值会带来线程不安全问题)

   2. ### 使用工具类创建

      + #### Collection.unmodifiableXXX : Collection，List，Set，Map

      + #### Guava : ImmutableXXX : Collection，List，Set，Map

2. ## 常见的线程不安全类以及注意事项

   1. ### StringBuilder与StringBuffer

      #### StringBuilder线程不安全，而StringBuffer是线程安全的

   2. ### SimpleDateFormat与JodaTime.DateTimeFormatter

      #### SimpleDateFormat是线程不安全的，如要使用最好用堆栈封闭起来。而DateTimeFormatter是线程安全

   3. ### ArrayList，HastSet，HashMap等Collections也是线程不安全的

   - #### 如果容器a的操作时线程安全的，但先检查再执行的操作 : if(condition(a)) {handle(a)} 的操作不一定线程安全，使用时应多多注意

3. ## 使用同步容器

   ### *常见的集合类都有对应的同步容器，同步容器底层才用synchronize，性能开销比较大，现一般都采用开销更小的并发容器*

   1. ### ArrayList与Vector，Stack

      #### 以Vector为例，它的每个方法都是线程安全的，但是不同的线程安全方法之间会因为执行顺序的问题导致线程不安全的问题出现(多个线程对Vector分别执行添加与删除很大几率会导致下标越界)

      #### 迭代器与foreach遍历循环Vector中不要执行删除操作，做好标记等出了循环在统一删除。否则会有并发操作问题

   2. ### HashMap与HashTable

      #### 需要注意的是，HashTable的key与value不能为null

   3. ### Collection.synchronizedXXX(List，Set，Map)也可以创建同步容器

4. ## 使用并发容器

   ### 常见的集合类都有对应的并发容器，很多都采用了写入时复制的机制，虽然可以保证最终一致性，适用于读多写少的场景，数据量大时写入的copy开销太大

   1. ### ArrayList与CopyOnWriteArrayList

      #### 并发容器单个的增删改是线程安全的，但是对全体元素的操作在底层还是调用多次单个操作，所以还要额外加锁才能保证线程安全

   2. ### HashSet，TreeSet与CopyOnWriteArraySet，ConcurrentSkipListSet

   3. ### HashMap，TreeMap与ConcurrentHashMap，ConcurrentSkipListMap

      #### 其中ConcurrentHashMap不允许插入空值

5. ## 线程封闭

   1. ### Ad-hoc线程封闭 : 程序控制实现，最糟糕，忽略

   2. ### 堆栈封闭 : 局部变量，没有并发问题

   3. ### ThreadLocal线程封闭 : 比较好的封闭方法

6. ## 总结-安全共享对象的策略

   1. ### 线程限制 : 一个被线程限制的对象，由线程独占，且只能被占用它的线程修改

   2. ### 共享只读 : 一个共享只读的对象，在没有额外同步的情况下能被多个线程并发访问，但都不允许修改

   3. ### 线程安全对象 : 一个线程安全的对象或者容器，在其内部通过同步机制保证线程安全，所以其他线程无序额外同步就可安全访问

   4. ### 被守护对象 : 只能通过获取特定的锁来访问