# ***权限管理***

1. ## ACL权限

   1. ### 概述

      #### 举个例子，你是房子的所有者，而你家人是房子的所属组，拥有对房子的居住于处置权。这时候有一间房需要出租，租户只能居住而不能随意处置房子。如何给租户赋予权限呢？把所有者改成租户，肯定不行。把所属组改为租户，或者把租户添加到家人行列中，也都不行。前面这几种都会导致租户权限过大。最后一种，给除了所有者与所属于组之外的用户都给与居住权限。这样租户权限倒是被限制了，却多了很多没有付房租的租客进来住。

      #### 通过这个例子，普通权限划分是有其局限性的。ACL 是用于解决用户对文件身份不足的问题的

   2. ### 开启 ACL

      ```shell
      [root@localhost ~]# dumpe2fs -h /dev/sda3 #dumpe2fs 命令是查询指定分区详细文件系统信息的命令 
      选项:
      -h 仅显示超级块中信息，而不显示磁盘块组的详细信息
      Default mount options: user_xattr acl ...
      省略部分输出...
      
      #例1：如果没有开启，手工开启分区的 ACL 权限
      [root@localhost ~]# mount -o remount,acl / 
      #重新挂载根分区，并挂载加入 acl 权限
      
      #例2：可以通过修改/etc/fstab 文件，永久开启 ACL 权限
      [root@localhost ~]# vi /etc/fstab
      UUID=c2ca6f57-b15c-43ea-bca0-f239083d8bd2 / ext4 defaults,acl 1 1 
      #加入 acl
      [root@localhost ~]# mount -o remount /
      #重新挂载文件系统或重启动系统，使修改生效
      ```

   3. ### ACL 基本命令

      #### getfacl 文件名 查询文件的 ACL 权限

      #### setfacl 选项 文件名 设定 ACL 权限

      #### -m 设定          ACL 权限

      #### -b 删除           ACL 权限

      #### -x:用户          删除单个用户的 ACL 权限

      #### setfacl -m u:用户名:权限      文件名

      #### setfacl -m g:组名:权限         文件名

      #### setfacl -m u:aa:rwx /test    给 test 目录赋予 aa 是读写执行的 ACL 权限

      #### setfacl -m u:cc:rx -R soft/    赋予递归 ACL 权限，只能赋予目录

      #### setfacl -m d:u:aa:rwx -R /test    ACL 默认权限，默认权限只能赋予目录

      

      ####  注意：如果给目录赋予 acl 权限，两条命令都要输入
      

      #### **递归与默认的区别：**

      #### setfacl -m u:cc:rx -R soft/    递归，只对已经存在的文件生效

      #### setfacl -m d:u:aa:rwx -R /test    默认，只对以后新建的文件生效

      

      #### 注意：执行递归命令会不可避免的造成权限溢出，因为执行权限对于目录与文件的作用不一样

   4. ### 最大有效权限 mask

      ```shell
      [root@localhost /]# setfacl -m m:rx project/ 
      #设定 mask 权限为 r-x。使用“m:权限”格式 
      [root@localhost /]# getfacl project/
      # file: project/
      # owner: root
      # group: tgroup     #effective:r-x
      user::rwx 
      group::rwx 
      mask::r-x
      #mask 权限变为了 r-x 
      other::---
      
      #注：实际生效ACL权限为mask与设置权限做与运算后的结果，实际中一般设定mask值为7
      ```

   5. ### 删除 ACL 权限

      ```shell
      [root@localhost /]# setfacl -x u:st /project/ #删除指定用户和用户组的 ACL 权限
      [root@localhost /]# setfacl -b project/ #会删除文件的所有的 ACL 权限
      ```
   
2. ## sudo 授权

   ### 目的是给普通用户赋予部分管理员权限。例如，/sbin/与/usr/sbin/目录下命令只有超级用户才能使用

      ### ***visudo 可以赋予普通用户权限命令，命令执行后和 vi 一样使用***

      ```shell
   root ALL=(ALL) ALL
   #用户名  被管理主机的地址=(可使用的身份)  授权命令(绝对路径) 
   #%wheel  ALL=(ALL)  ALL
   #%组名  被管理主机的地址=(可使用的身份)  授权命令(绝对路径)
      ```

   + #### 用户名/组名:代表 root 给哪个用户或用户组赋予命令，注意组名前加“%”

   + #### 用户可以用指定的命令管理指定 IP 地址的服务器。如果写 ALL，代表可以管理任何主机，如 果写固定 IP，代表用户可以管理指定的服务器。(这里真的很奇怪啊，原来一直认为这里的 IP 地址管理的是登录者来源的 IP 地址，查了很多资料也都是这样的。直到有一天查看 “man 5 sudoers”帮助，才发现大家原来都理解错误了，这里的 IP 指定的是用户可以管理 哪个 IP 地址的服务器。那么如果你是一台独立的服务器，这里写 ALL 和你服务器的 IP 地址， 作用是一样的。而写入网段，只有对 NIS 服务这样用户和密码集中管理的服务器才有意义)。 如果我们这里写本机的 IP 地址，不代表只允许本机的用户使用指定命令，而代表指定的用户可以从任何 IP 地址来管理当前服务器

   + #### 可使用身份:就是把来源用户切换成什么身份使用，(ALL)代表可以切换成任意身份。这个字段可以省略

   + #### 授权命令:代表 root 把什么命令授权给普通用户。默认是 ALL，代表任何命令，这个当然不行。如果需要给那个命令授权，写入命令名即可，不过需要注意一定要命令写成绝对路径

   ```shell
   #例1：授权用户 user1 可以重启服务器，则由 root 用户添加如下行
   [root@localhost ~]# visudo
   user1 ALL= /sbin/shutdown –r now 
      
   [user1@localhost ~]$ sudo -l 
   #user1 查看可用的授权
   ```

   ```shell
   #例2：授权一个用户管理你的 Web 服务器，首先分析授权用户管理 Apache 至少要实现哪些基本授权
   #A.可以使用 Apache 管理脚本
   #B.可以修改 Apache 配置文件
   #C.可以更新网页内容
      
   #Aapche 管理脚本程序为/etc/rc.d/init.d/httpd 。 为满足条件一，用 visudo 进行授权
   [root@localhost ~]# visudo
   user1 192.168.0.156=/etc/rc.d/init.d/httpd reload,\ 
   /etc/rc.d/init.d/httpd configtest
   #授权用户 user1 可以连接 192.168.0.156 上的 Apache 服务器，通过 Apache 管理脚本重新读取配 置文件让更改的设置生效(reload)和可以检测 Apache 配置文件语法错误(configtest)，但不允 许其执行关闭(stop)、重启(restart)等操作。(“\”的意思是一行没有完成，下面的内容和上 一行是同一行。)
      
   #为满足条件二，同样使用 visudo 授权
   [root@localhost ~]# visudo
   user1 192.168.0.156=/binvi /etc/httpd/conf/httpd.conf
   #授权用户 user1 可以用 root 身份使用 vi 编辑 Apache 配置文件。以上两种 sudo 的设置，要特别注意，很多朋友使用 sudo 会犯两个错误:第一，授权命令没有细化到选项和参数;第二，认为只能授权管理员执行的命令。 
      
   #为满足条件三则比较简单，假设网页存放目录为/var/www/html ，则只需要授权 user1 对此目录具有写权限 或者索性更改目录所有者为 user1 即可。如果需要，还可以设置 user1 可以通过 FTP 等文件共享服务更新网页
   ```

   ```shell
   #例3：授权 aa 用户可以添加其他普通用户
   aa ALL=/usr/sbin/useradd #赋予 aa 添加用户权限.命令必须写入绝对路径
   aa ALL=/usr/bin/passwd #错误示例，赋予改密码权限，aa用户可以对 root 的密码修改，权限过大
   aa ALL=/usr/bin/passwd [A-Za-z]*, !/usr/bin/passwd "", !/usr/bin/passwd root
   ##正确示例，只允许aa用户修改其他用户的密码，不能修改root用户的密码
   sudo /usr/sbin/useradd ee #普通用户使用 sudo 命令执行超级用户命令
   ```

3. ## 文件特殊权限 SetUID、SetGID、Sticky BIT

   1. ### SetUID

      #### SetUID 的功能可以这样理解：

      + ##### 只有可以执行的二进制程序才能设定 SUID 权限

      + ##### 命令执行者要对该程序拥有 x(执行)权限

      + #####  命令执行者在执行该程序时获得该程序文件属主的身份(在执行程序的过程中灵魂附体为文件的所有者)

      + ##### SetUID 权限只在该程序执行过程中有效，也就是说身份改变只在程序执行过程中有效

      ```shell
      #例：系统默认给/usr/bin/passwd 命令设置了特殊权限 SetUID，这样普通用户才能修改自己的密码
      [root@localhost ~]# ll /etc/passwd
      -rw-r--r-- 1 root root 1728 1 月 19 04:20 /etc/passwd 
      [root@localhost ~]# ll /etc/shadow
      ---------- 1 root root 1373 1 月 19 04:21 /etc/shadow
      #普通用户对于存放用户信息与密码信息的文件没有修改权限
             
      [root@localhost ~]# ll /usr/bin/passwd
      -rwsr-xr-x 1 root root 25980 2 月 22 2012 /usr/bin/passwd
      #系统对修改密码的程序赋予了 SetUID 权限，这样普通用户在改密码命令时切换到root身份才能修改用户信息文件
             
      #/usr/bin/passwd 命令拥有特殊权限 SetUID ，也就是在属主的权限位的执行权限上是 s。可以这样 来理解它:当一个具有执行权限的文件设置 SetUID 权限后，用户执行这个文件时将以文件所有者的身份执行。/usr/bin/passwd命令具有SetUID权限，所有者为roo(t Linux中的命令默认所有者都是root)， 也就是说当普通用户使用 passwd 更改自己密码的时候，那一瞬间突然灵魂附体了，实际是在用 passwd 命令所有者 root 的身份在执行 passwd 命令，root 当然可以将密码写入/etc/shadow 文件(不要忘记 root 这个家伙是 superman 什么事都可以干)，所以普通用户也可以修改/etc/shadow 文件，命令执行完成 后该身份也随之消失
      ```

      #### SetUID 权限非常危险，不建议手动更改 SetUID权限使用默认的就好，生成环境中可以设置脚本检测SetUID权限是否设置合理

      ```shell
      #例子：执行 SetUID 权限检测脚本
      [root@localhost ~]# vi suidcheck.sh
      #!/bin/bash
      find / -perm -4000 -o -perm -2000 > /tmp/setuid.check 
      #搜索系统中所有拥有 SUID 和 SGID 的文件，并保存到临时目录中。
      for i in $(cat /tmp/setuid.check) #做循环，每次循环取出临时文件中的文件名
      do
                 grep $i /root/suid.list > /dev/null #比对这个文件名是否在模板文件中
                     if [ "$?" != "0" ] #如果在，不报错
                     then
                         echo "$i isn't in listfile! " >> /root/suid_log_$(date +%F)
                         #如果文件名不再模板文件中，则报错。并把报错报错到日志中
                     fi
      done
      rm -rf /tmp/setuid.check #删除临时文件
      [root@localhost ~]# chmod u+s /bin/vi 
      #手工给 vi 加入 SUID 权限
      [root@localhost ~]# ./suidcheck.sh 
      #执行检测脚本
      [root@localhost ~]# cat suid_log_2013-01-20 
      /bin/vi isn't in listfile!
      #报错了，vi 不再模板文件中。代表 vi 被修改了 SUID 权限
      ```

   2. ### SetUID

      #### ***SGID 即可以针对文件生效，也可以针对目录生效，这和 SUID 明显不同***

      #### 针对文件，SGID 的 含义如下：

      + ##### 只有可执行的二进制程序才能设置 SGID 权限

      + ##### 命令执行者要对该程序拥有 x(执行)权限

      + ##### 命令执行在执行程序的时候，组身份升级为该程序文件的所属组

      + ##### SetGID 权限同样只在该程序执行过程中有效，也就是说组身份改变只在程序执行过程中有效

      ```shell
      #例：locate命令会去查找本地数据库中的索引，但是普通用户是无权查看本地数据库的
           
      [root@localhost ~]# ll /var/lib/mlocate/mlocate.db
      -rw-r----- 1 root slocate 1838850 1 月 20 04:29 /var/lib/mlocate/mlocate.db
      #普通用户无权查看本地索引数据库，所有者权限是 r、w，所属组权限是 r，但是其他人权限是 0
           
      [root@localhost ~]# ll /usr/bin/locate
      -rwx--s--x 1 root slocate 35612 8 月 24 2010 /usr/bin/locate
      #locate命令被赋予了SetUID权限
           
      #这样，当普通用户 user1 执行 locate 命令时会发生如下事情：
      #/usr/bin/locate 是可执行二进制程序，可以赋予 SGID；
      #执行用户 user1 对/usr/bin/locate 命令拥有执行权限；
      #执行/usr/bin/locate 命令时，组身份会升级为 slocate 组，而 slocate 组对/var/lib/mlocate/mlocate.db 数据库拥有 r 权限，所以普通用户可以使用 locate 命令查询mlocate.db 数据库
      #命令结束，user1 用户的组身份返回为 user1 组
      ```

      #### SGID 针对目录设置，含义如下：

      + ##### 普通用户必须对此目录拥有 r 和 x 权限，才能进入此目录

      + ##### 普通用户在此目录中的有效组会变成此目录的属组

      + ##### 若普通用户对此目录拥有 w 权限时，新建的文件的默认属组是这个目录的属组

      ```shell
      #例子：
      [root@localhost ~]# cd /tmp/
      #进入临时目录做此实验。因为临时目录才允许普通用户修改 
      [root@localhost tmp]# mkdir dtest
      #建立测试目录
      [root@localhost tmp]# chmod g+s dtest 
      #给测试目录赋予 SGID
      [root@localhost tmp]# ll -d dtest/
      drwxr-sr-x 2 root root 4096 1 月 20 06:04 dtest/
      #SGID 已经生效
      [root@localhost tmp]# chmod 777 dtest/ 
      #给测试目录权限，让普通用户可以写
      [root@localhost tmp]# su – user1
      #切换成普通用户 user1
      [user1@localhost ~]$ cd /tmp/dtest/
      #普通用户进入测试目录
      [user1@localhost dtest]$ touch abc
      #普通用户建立 abc 文件
      [user1@localhost dtest]$ ll
      总用量 0
      -rw-rw-r-- 1 user1 root 0 1 月 20 06:07 abc
      #abc 文件的默认属组不再是 user1 用户组，而变成了 dtest 组的属组 root
      ```

   3. ### 文件特殊权限之 Sticky BIT

      #### Sticky BIT 粘着位，也简称为 SBIT。SBIT 目前仅针对目录有效，作用如下：

      + ##### 粘着位目前只对目录有效

      + ##### 普通用户对该目录拥有 w 和 x 权限（一般也都带有读权限），即普通用户可以在此目录拥有写入权限

      + #####  如果没有粘着位，因为普通用户拥有 w 权限，所以可以删除此目录下所有文件，包括其他用户建立的文件。一但赋予了粘着位，除了 root 可以删除所有文件，普通用户就算拥有 w 权 限，也只能删除自己建立的文件，但是不能删除其他用户建立的文件

   4. ### 设定文件特殊权限

      #### 特殊权限这样来表示：

      + ##### 4 代表 SUID

      + ##### 2 代表 SGID

      + ##### 1 代表 SBIT

      ```shell
      [root@localhost ~]# chmod 4755 ftest 
      #赋予 SUID 权限
      [root@localhost ~]# chmod 2755 ftest 
      #赋予 SGID 权限
      [root@localhost ~]# mkdir dtest 
      [root@localhost ~]# chmod 1755 dtest/ 
      #SBIT 只对目录有效，所以建立测试目录，并赋予 SBIT
      ```

4. ## 文件系统属性 chattr 权限

      ```shell
   #命令格式
   [root@localhost ~]# chattr [+-=] [选项] 文件或目录名 
   选项:
   +: 增加权限
   -: 删除权限
   =: 等于某权限
   i: 如果对文件设置 i 属性，那么不允许对文件进行删除、改名，也不能添加和修改数
   据;如果对目录设置 i 属性，那么只能修改目录下文件的数据，但不允许建立和删除文件。
   a: 如果对文件设置 a 属性，那么只能在文件中增加数据，但是不能删除也不能修改数 据;如果对目录设置 a 属性，那么只允许在目录中建立和修改文件，但是不允许删除 
   e: Linux 中绝大多数的文件都默认拥有 e 属性。表示该文件是使用 ext 文件系统进行存储的，而且不能使用“chattr -e”命令取消 e 属性
      
   #查看文件系统属性
   [root@localhost ~]# lsattr 选项 文件名 
   选项:
   -a 显示所有文件和目录
   -d 若目标是目录，仅列出目录本身的属性，而不是子文件的
      
      
   #例1：
   #给文件赋予 i 属性
   [root@localhost ~]# touch ftest 
   #建立测试文件
   [root@localhost ~]# chattr +i ftest 
   [root@localhost ~]# rm -rf ftest
   rm: 无法删除"ftest": 不允许的操作 
   #赋予 i 属性后，root 也不能删除 
   [root@localhost ~]# echo 111 >> ftest -bash: ftest: 权限不够 
   #也不能修改文件的数据
   #给目录赋予 i 属性
   [root@localhost ~]# mkdir dtest
   #建立测试目录
   [root@localhost dtest]# touch dtest/abc 
   #再建立一个测试文件 abc
   [root@localhost ~]# chattr +i dtest/ 
   #给目录赋予 i 属性
   [root@localhost ~]# cd dtest/ 
   [root@localhost dtest]# touch bcd
   touch: 无法创建"bcd": 权限不够
   #dtest 目录不能新建文件
   [root@localhost dtest]# echo 11 >> abc 
   [root@localhost dtest]# cat abc
   11
   #但是可以修改文件内容
   [root@localhost dtest]# rm -rf abc rm: 无法删除"abc": 权限不够 
   #不能删除
      
      
   #例2：
   [root@localhost ~]# mkdir -p /back/log
   #建立备份目录
   [root@localhost ~]# chattr +a /back/log/
   #赋予 a 属性
   [root@localhost ~]# cp /var/log/messages /back/log/ 
   #可以复制文件和新建文件到指定目录
   [root@localhost ~]# rm -rf /back/log/messages
   rm: 无法删除"/back/log/messages": 不允许的操作 
   #但是不允许删除
      ```