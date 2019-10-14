# ***Java内存模型***

1. ## Java内存模型

   ### Java内存模型Java Memory Model屏蔽了平台与硬件的差异，使Java程序在各处运行都能达到一致的效果，JVM规范中定义了Java内存模型。JMM规范了JVM与计算机内存直接是如何协同工作的，规定了一个线程如何与何时可以看到其他线程修改过的共享变量的值，以及在必须时如何同步的访问共享变量。

![Java内存模型](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/092.jpg)

![Java内存模型抽象结构图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/093.jpg)

2. ## 八种同步操作于同步规则

![正事配图](https://raw.githubusercontent.com/undermoonoldman/JavaFamilyBucket/master/Resource/IMG/094.jpg)

1. ### **同步操作**

+ ### lock(锁定) : 作用于主内存变量，把一个变量标识为一条线程独占状态

+ ### unlock(解锁) : 作用于主内存的变量，把一个处于锁定状态的变量释放出来，可以被其他线程锁定

+ ### read(读取) : 作用于主内存的变量，把一个变量从主内存传输到线程的工作内存中，以便之后的load动作使用

+ ### load(载入) : 作用于工作内存的变量，把read操作从主内存中得到的变量值放入工作内存的变量副本中

+ ### use(使用) : 作用于工作内存的变量，把工作内存中的一个变量值传递给执行引擎

+ ### assing(赋值) : 作用于工作内存的变量，把一个从执行引擎接收到的值赋给工作内存的变量

+ ### store(存储) : 作用于工作内存的变量，把工作内存中的一个变量的值传送到主内存中，便于之后的write操作

+ ### write(写入) : 作用于主内存的变量，把store操作传过来的值传到主内存的变量中

2. ### **同步规则**

+ ### 变量从主内存复制到工作内存，要按顺序执行read与load；把变量从工作内存同步回主内存，要顺序执行store与write操作。注意：JMM要求上述操作是顺序执行，不是强制要连续执行

+ ### 不允许read与load，store与write操作只一单独出现

+ ### 不允许一个线程丢弃最近的assign操作，即变量在工作内存中改变了之后必须同步到主内存中去

+ ### 不允许一个线程无故(没有发生任何assign操作)就把数据从工作内存同步会主内存中去

+ ### 新变量只能在主内存中诞生，不允许在工作内存中直接使用一个未被初始化(load或assign)的变量。即为对一个变量实施use与store操作之前，必须先执行assign与load操作

+ ### 一个变量在同一时刻只允许一条线程对其进行lock操作，但lock操作可以被同一条线程多次重复执行，多次lock后必须执行相同次数的unlock操作变量才能被解锁。lock与unlock必须成对出现

+ ### 对一个变量执行lock，会清空工作内存中该变量的值，在执行引擎使用该变量前需要重新load或assign操作来初始化变量的值

+ ### 变量事先没有被lock锁定，则不允许对其执行unlock操作，unlock一个被其他线程锁定的变量也是不允许的

+ ### 对一个变量执行unlock前，必须把此变量同步到主内存中(执行store与write操作)

