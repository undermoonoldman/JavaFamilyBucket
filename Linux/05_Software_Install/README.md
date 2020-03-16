# ***软件安装***

1. ## 软件包分类

   1. ### 源码包

      1. #### 源码包的优点是

      - ##### 开源，如果有足够的能力，可以修改源代码

      - ##### 可以自由选择所需的功能

      - ##### 软件是编译安装，所以更加适合自己的系统，更加稳定也效率更高

      - ##### 卸载方便

      2. #### 源码包的缺点

      - ##### 安装过程步骤较多，尤其安装较大的软件集合时(如 LAMP 环境搭建)，容易出现拼写 错误

      - ##### 编译过程时间较长，安装比二进制安装时间长

      - ##### 因为是编译安装，安装过程中一旦报错新手很难解决

   2. ### 二进制包

      1. #### 二进制包分类

      - ##### DPKG 包：是由 Debian Linux 所开发出来的包管理机制，通过 DPKG 包，Debian Linux 就可以进行软件包管理。主要应用在 Debian 和 unbuntu 中

      - ##### RPM 包：是由 Red Hat 公司所开发的包管理系统。功能强大，安装、升级、查询和卸载 都非常简单和方便。目前很多 Linux 都在使用这种包管理方式，包括 Fedora、CentOS、 SuSE 等

      2. #### RPM 包的优点

      - ##### 包管理系统简单，只通过几个命令就可以实现包的安装、升级、查询和卸载

      - ##### 安装速度比源码包安装快的多

      3. #### RPM 包的缺点

      - ##### 经过编译，不再可以看到源代码

      - ##### 功能选择不如源码包灵活

      - #####  依赖性。有时我们会发现需要安装软件包a时需要先安装b和c，而安装b时需要安装d 和 e。这是需要先安装 d 和 e，再安装 b 和 c，最后才能安装 a 包。比如说，我买了个 漂亮的灯具，打算安装到我们家客厅，可是在安装灯具之前我们家客厅总要有顶棚吧， 顶棚总要是做好了防水和刷好油漆了吧，这个装修和安装软件其实类似总要有一定的顺 序的。可是有时依赖性会非常繁琐
      
      4. #### RPM包依赖
      
      + ##### 树形依赖 a---->b---->c
      
      + ##### 环形依赖 a---->b---->c---->a
      
      + ##### 函数库依赖
      
      ```shell
      例子：函数依赖
      [root@localhost Packages]# rpm -ivh mysql-connector-odbc-5.2.5-7.el7.x86_64.rpm
      错误:依赖检测失败:
      libodbc.so.2()(64bit) 被 mysql-connector-odbc-5.2.5-7.el7.x86_64 需要 libodbcinst.so.2()(64bit) 被 mysql-connector-odbc-5.2.5-7.el7.x86_64 需要
      
      #发现报错，需要安装“libodbc.so.2”函数库文件，这时会发现在光盘中根本找不到这个文件。那是 因为函数库没有单独成包，是包含在某一个软件包中的。而如果要知道在哪个软件包中，需要查询网站 www.rpmfind.net
      ```
   
2. ## RPM安装

   1. ### RPM包命名规则

      ```shell
      httpd-2.2.15-15.el6.centos.1.i686.rpm
      ```

      + ##### httpd   软件包名

      + ##### 2.2.15   软件版本

      + ##### 15   软件发布的次数

      + ##### el6   软件发行商。el6 是 RedHat 公司发布，适合 RHEL6.x(Red Hat Enterprise Linux)和 CentOS6.x下使用

      + ##### i686   适合的硬件平台。RPM 包可以在不同的硬件平台安装，选择适合不同 CPU 的软件版本，可以最大化的发挥 CPU 性能，所以出现了所谓的 i386(386 以上计算机都可以安装)、i586(586 以上的计算机都可以安装)、i686(奔腾 II 以上计算机都可以安装，目前所有的 CPU 都是 奔腾 II 以上，所以这个软件版本居多)、x86_64(64 位 CPU 可以安装)和 noarch(没有硬 件限制)等文件名了

      + ##### rpm     包的扩展名。我们说过 Linux 下文件不是靠扩展名区分文件类型，也就是 Linux 中扩展 名没有任何含义。可是这里怎么又出现了扩展名呢?原因很简单，如果我不把 RPM 的扩展名 叫做“.rpm”，管理员很难知道这是一个 RPM 包，当然也就无法正确安装了。也就是说如果 RPM 包不用“.rpm”作为扩展名，系统可以正确识别没有问题，可是管理员很难识别这是个 什么样的软件

      #### ***包全名:如果操作的是未安装软件包，则使用包全名，而且需要注意绝对路径***

      #### ***包名:如果操作的是已经安装的软件包，则使用包名即可，系统会生产 RPM 包的数据库(/var/lib/rpm/)，而且可以在任意路径下操作***

   2. ### RPM包手工命令安装

      1. #### 默认安装位置

      | 路径            |            作用            |
      | --------------- | :------------------------: |
      | /etc/           |      配置文件安装目录      |
      | /usr/bin/       |    可执行的命令安装目录    |
      | /usr/lib/       | 程序所使用的函数库保存位置 |
      | /usr/share/doc/ | 基本的软件使用手册保存位置 |
      | /usr/share/man/ |      帮助文件保存位置      |

      2. #### RPM 包安装

      ```shell
      rpm –ivh 包全名 
      #注意一定是包全名。如果跟包全名的命令要注意路径，因为软件包在光盘当中 
      选项:
      -i install 安装(install)
      -v 显示更详细的信息(verbose)
      -h 打印显示安装进度(hash)
      --nodeps 不检测依赖性安装。软件时会检测依赖性，确定所需的底层软件是否安装。 如果没有安装则会报错。如果我不管依赖性，想强行安装，可以使用这个选项。注意: 这样不检测依赖性安装的软件基本是不能使用的，所以不建议这样做
      --replacefiles 替换文件安装。如果安装软件包，可是包中部分文件已经存在，正常安装时候，会报错“某个文件已经存在”从而导致软件无法安装，使用这个选项可 以忽视这个报错，而覆盖安装
      --replacepkgs 替换软件包安装。如果软件包已经安装，此选项可以把软件包重复安装一遍
      --force 强制安装。不管是否已经安装，都重新安装。就是—replacefiles 和 —replacepkgs 的综合
      --test 测试安装。不会实际安装，只是检测一下依赖性
      --prefix 指定安装路径。为安装软件指定安装路径，而不使用默认安装路径。注意:
      如果指定了安装路径，软件没有安装到系统默认路径中的话，系统会找不到这些安装的
      软件，需要进行手工配置才能被系统识别。所以 rpm 包我们一般都采用默认路径安装
      ```

      3. #### 服务启动

      ```shell
      [root@localhost ~]# service 服务名 start|stop|restart|status 
      参数:
      start: 启动服务 
      stop: 停止服务
      restart: 重启服务
      status: 查看服务状态
      
      [root@localhost ~]# systemctl start|stop|restart|status 服务名 
      #这个命令也行
      ```

      4. #### RPM包升级

      ```shell
      [root@localhost ~]# rpm –Uvh 包全名 
      选项:
      -U(大写) 升级安装，如果没有安装过，系统直接安装。如果安装过的版本较旧，则升级到新版本(upgrade)
      [root@localhost ~]# rpm –Fvh 包全名
      选项:
      -F(大写) 升级安装，如果没有安装过，则不会安装。必须安装有较旧版本，才能升级(freshen)
      ```

      5. #### 卸载

      ```shell
      [root@localhost ~]# rpm -e 包名 
      选项:
      --nodeps 不检查依赖性 
      -e 卸载
      ```

      6. #### 查询

      ```shell
      例1：查询软件包是否安装
      [root@localhost ~]# rpm –q 包名 
      选项:
      -q: 查询(query)
      
      例2：查询系统中所有已经安装的软件包
      [root@localhost ~]# rpm -qa 
      选项:
      -a:所有(all)
      
      例3：查询已经安装的某个软件包的详细信息
      [root@localhost ~]# rpm –qi 包名 
      选项:
      -i: 查询软件信息(information)
      
      例3：查询还没有安装的软件包的详细信息
      [root@localhost ~]# rpm –qip 包全名 
      选项:
      -p: 查询没有安装的软件包(package)
      
      例4：查询已经安装的软件包中的文件列表和安装的完整目录
      [root@localhost ~]# rpm –ql 包名 
      选项:
      -l: 列出软件包中所有的文件列表和软件所安装的目录(list)
      
      例5：查询还没有安装的软件包中的文件列表和打算安装的位置
      [root@localhost ~]# rpm –qlp 包全名
      
      例6：查询系统文件属于哪个 RPM 包，手工建立的文件是不能查询的
      [root@localhost ~]# rpm –qf 系统文件名 
      选项:
      -f: 查询系统文件属于哪个软件包(file)
      
      例7：查询系统中和已经安装的软件包有依赖关系的软件包
      [root@localhost ~]# rpm –qR 包名 
      选项:
      -R: 查询软件包的依赖性(requires)
      ```

      7. #### 验证

      ```shell
      [root@localhost ~]# rpm –Va 
      选项:
      -Va 校验本机已经安装的所有软件包
      
      [root@localhost ~]# rpm –V 已安装的包名 
      选项:
      -V 校验指定RPM包中的文件(verify)
      
      [root@localhost ~]# rpm –Vf 系统文件名 
      选项:
      -Vf 校验某个系统文件是否被修改
      
      例子：
      [root@localhost ~]# rpm -V httpd
      S.5....T.        c        /etc/httpd/conf/httpd.conf 
      验证内容        文件类型     文件名
      ```

      ##### 最前面共有 8 个信息内容，是表示验证内容的。文件名前面的 c 是表示这是个配置文件(configuration)。最后是文件名。

      ##### 8种验证内容信息：

      + ##### S 文件大小是否改变

      + ##### M 文件的类型或文件的权限(rwx)是否被改变

      + ##### 5 文件 MD5 校验和是否改变(可以看成文件内容是否改变)

      + ##### D 设备的主从代码是否改变

      + ##### L 文件路径是否改变

      + ##### U 文件的属主(所有者)是否改变

      + ##### G 文件的属组是否改变

      + ##### T 文件的修改时间是否改变

      ##### 5种文件类型：

      + ##### c 配置文件(config file)

      + ##### d 普通文档(documentation)

      + ##### g 鬼”文件(ghost file)，很少见，就是该文件不应该被这个 RPM 包所包含

      + ##### l 授权文件(license file)

      + ##### r 描述文件(read me)

      8. #### 数字证书

      ##### ***刚刚的校验方法只能对已经安装的 RPM 包中的文件进行校验，但是如果 RPM 包本身就被动过手脚， 那么校验就不能解决问题了。我们就必须使用数字证书验证，数字证书有如下特点：***

      + ##### 首先必须找到原厂的公钥文件，然后进行安装

      + ##### 安装RPM包是，会去提取RPM包中的证书信息，然后和本机安装的原厂证书进行验证

      + ##### 如果验证通过，则允许安装;如果验证不通过，则不允许安装并警告

      

      1. + ##### 数字证书位置

      ```shell
      #数字证书在 CentOS 6.3 的第一张光盘中就有，当然它默认也会放在系统中
      
      [root@localhost ~]# ll /mnt/cdrom/RPM-GPG-KEY-CentOS-6
      -r--r--r-- 2 root root 1706 7 月 2 04:21 /mnt/cdrom/RPM-GPG-KEY-CentOS-6 
      #光盘中的数字证书位置
      
      [root@localhost ~]# ll /etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
      -rw-r--r--. 1 root root 1706 6 月 26 17:29 /etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6 
      #系统中的数字证书位置
      ```

      2. + ##### 数字证书导入与查询

      ```shell
      [root@localhost ~]# rpm --import /etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6 
      选项:
      --import 导入数字证书
      
       [root@localhost ~]# rpm -qa | grep gpg-pubkey 
       gpg-pubkey-c105b9de-4e0fd3a3
       #查询系统中安装好的数字证书
      ```

      9. #### RPM包中文件的提取

      ##### ***cpio 命令主要有三种基本模式:“-o”模式指的是 copy-out 模式，就是把数据备份到文件库中; “-i”模式指的是 copy-in 模式，就是把数据从文件库中恢复;“-p”模式指的是复制模式，就是不 把数据备份到 cpio 库中，而是直接复制为其他文件***

      ```shell
      [root@localhost ~]# cpio -o[vcB] > [文件|设备] 
      #备份
      选项:
      -o:copy-out 模式，备份
      -v:显示备份过程
      -c:使用较新的 portable format 存储方式 
      -B:设定输入输出块为 5120bytes，而不是模式的 512butes
      
      [root@localhost ~]# cpio -i[vcdu] < [文件|设备] 
      #还原
      选项:
      -i:copy-in 模式，还原 
      -v:显示还原过程
      -c:使用较新的 portable format 存储方式 
      -d:还原时自动新建目录 
      -u:自动使用较新的文件覆盖较旧的文件
      
      [root@localhost ~]# cpio -p 目标目录
      
      
      例1:利用 find 命令找到文件，备份
      [root@localhost ~]# find /etc -print | cpio -ocvB > /root/etc.cpio 
      #利用 find 指定要备份/etc/目录，使用>导出到 etc.cpio 文件
      [root@localhost ~]# ll -h etc.cpio
      -rw-r--r--. 1 root root 21M 6 月 5 12:29 etc.cpio
      #etc.cpio 文件生成
      
      例2：恢复 cpio 的备份数据
      [root@localhost ~]# cpio -idvcu < /root/etc.cpio 
      #还原 etc 的备份
      #但是如果大家查看下当前目录/root，会发现没有生成 etc 目录。这是因为备份是/etc 目录使用的是绝对路径，所以 恢复的数据直接恢复到了/etc 系统目录中，而没有生成在/root/etc 中
      
      
      #CentOS5.x 的版本中，是可以利用上面的命令备份与恢复指定的文件。但是到 CentOS6.x 当中， 需要更加严谨。如果备份时使用绝对路径，则恢复的数据会直接到绝对路径指定的路径中，如果需要 把数据恢复到当前目录中，则需要使用相对路径
      例子：
      #备份:
      [root@localhost ~]# cd /etc
      #进入/etc 目录
      [root@localhost ~]# find . -print | cpio -ocvB > /root/etc.cpio 
      #利用 find 指定要备份/etc/目录，使用>导出到 etc.cpio 文件
      #恢复:
      [root@localhost ~]# cd /root
      #回到/root 目录中
      [root@localhost ~]# mkdir etc_test
      #建立恢复测试目录
      [root@localhost ~]# cd etc_test
      #进入测试目录，数据恢复到此
      [root@localhost etc_test]# cpio -idvcu < /root/etc.cpio
      #还原/etc 目录的数据，因为备份时使用的是相对路径，则会还原到/root/etc_test/目录下
      
      例3：cpio 命令的“-p”复制模式
      [root@localhost ~]# cd /tmp/ 
      #进入/tmp 目录
      [root@localhost tmp]# rm -rf * 
      #删除/tmp 目录中所有数据 
      [root@localhost tmp]# mkdir test 
      #建立备份目录
      [root@localhost tmp]# find /boot/ -print | cpio -p /tmp/test 
      #备份/boot/目录到/tmp/test/目录中
      [root@localhost tmp]# ls test/
      boot
      #在/tmp/test/目录中备份出了 boot 目录
      ```

      ```shell
      [root@localhost ~]# rpm2cpio 包全名 | cpio -idv .文件绝对路径 
      rpm2cpio  是将 rpm 包转换为 cpio 格式的命令
      cpio  是一个标准工具，它用于创建软件档案文件和从档案文件中提取文件
      
      
      #举个例子，现在我假设把系统中的/bin/ls 命令不小心误删除了，那么我可以修复回来吗?这时有两 种方法修复，要不就是使用—force 选项覆盖安装一遍 coreutils-8.4-19.el6.i686 包，要不就可以 使用 cpio 命令提取出/bin/ls 命令文件，再把它拷贝到对应位置就可以了。不过我是怎么知道/bin/ls 命令是属于 coreutils-8.4-19.el6.i686 这个软件包的呢?还记得-qf 选项吗?命令如下:
      [root@localhost ~]# rpm -qf /bin/ls
       coreutils-8.4-19.el6.i686 
       #查看 ls 文件属于哪个软件包
       
       #那么我们使用cpio 命令提取出 ls 命令文件，然后拷贝到对应位置，命令如下
      [root@localhost ~]# mv /bin/ls /root/ 
      #把/bin/ls 命令移动到/root 目录下，造成误删除的假象
      [root@localhost ~]# ls
      -bash: ls: command not found
      #这时执行 ls 命令，系统会报错“命令没有找到”
      [root@localhost ~]# rpm2cpio /mnt/cdrom/Packages/coreutils-8.4-19.el6.i686.rpm | cpio -idv ./bin/ls
      ./bin/ls
      24772 块
      #提取 ls 命令文件到当前目录下
      [root@localhost ~]# cp /root/bin/ls /bin/ 
      #把提取出来的 ls 命令文件复制到/bin 目录下
      [root@localhost ~]# ls
      anaconda-ks.cfg bin inittab install.log install.log.syslog ls 
      #这时，ls 命令又可以正常使用了
      ```

      10. #### rpm包在线安装

          1. ##### yum源文件解析

             ###### yum 源配置文件保存在/etc/yum.repos.d/目录中，文件的扩展名一定是“*.repo”。也就是说， yum 源配置文件只要扩展名是“*.repo”就会生效

             ```shell
              [root@localhost ~]# ls /etc/yum.repos.d/
             CentOS-Base.repo CentOS-Debuginfo.repo CentOS-fasttrack.repo CentOS-Media.repo CentOS-Vault.repo
             
             #目录中有5个 yum 源配置文件，默认情况下 CentOS-Base.repo 文件生效。我们打开这个文件看看
             [root@localhost yum.repos.d]# vim /etc/yum.repos.d/CentOS-Base.repo
             [base]
             name=CentOS-$releasever - Base mirrorlist=http://mirrorlist.centos.org/?release=$releasever&arch=$basearch& repo=os
             baseurl=http://mirror.centos.org/centos/$releasever/os/$basearch/ gpgcheck=1
             gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
             ```

             + ###### [base]:容器名称，一定要放在[]中

             + ###### name:容器说明，可以自己随便写

             + ###### mirrorlist:镜像站点，这个可以注释掉

             + ######  baseurl:我们的 yum 源服务器的地址。默认是 CentOS 官方的 yum 源服务器，是可以使用的。
               如果你觉得慢，则可以改成你喜欢的 yum 源地址

             + ######  enabled:此容器是否生效，如果不写或写成 enabled=1 则表示此容器生效，写成 enabled=0
               则表示此容器不生效

             + ###### gpgcheck:如果为 1 则表示 RPM 的数字证书生效;如果为 0 则表示 RPM 的数字证书不生效

             + ###### gpgkey:数字证书的公钥文件保存位置。不用修改

          2. ##### 搭建本地光盘yum源

             ###### 放入 CentOS 安装光盘，并挂载光盘到指定位置

             ```shell
             [root@localhost ~]# mkdir /mnt/cdrom
             #创建 cdrom 目录，作为光盘的挂载点
             [root@localhost ~]# mount /dev/cdrom /mnt/cdrom/
             mount: block device /dev/sr0 is write-protected, mounting read-only 
             #挂载光盘到/mnt/cdrom 目录下
             ```

             ###### 修改其他几个 yum 源配置文件的扩展名，让它们失效，因为只有扩展名是“*.repo”的 文件才能作为 yum 源配置文件。当然也可以删除其他几个 yum 源配置文件，但是如果删除了，当你 又想用网络作为 yum 源时，就没有了参考文件，所以最好还是修改扩展名

             ```shell
             [root@localhost ~]# cd /etc/yum.repos.d/
             [root@localhost yum.repos.d]# mv CentOS-Base.repo CentOS-Base.repo.bak 
             [root@localhost yum.repos.d]# mv CentOS-Debuginfo.repo CentOS-Debuginfo.repo.bak 
             [root@localhost yum.repos.d]# mv CentOS-Vault.repo CentOS-Vault.repo.bak
             ```

             ###### 修改光盘 yum 源配置文件 CentOS-Media.repo

             ```shell
             [root@localhost yum.repos.d]# vim CentOS-Media.repo [c6-media]
             name=CentOS-$releasever - Media 
             baseurl=file:///mnt/cdrom 
             #地址为你自己的光盘挂载地址
             #        file:///media/cdrom/
             # file:///media/cdrecorder/ #注释这两个不存在的地址
             gpgcheck=1
             enabled=1
             #把 enabled=0 改为 enabled=1，让这个 yum 源配置文件生效 
             gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-CentOS-6
             ```

          3. ##### yum命令

             ###### 查询

             ```shell
             [root@localhost yum.repos.d]# yum list 
             #查询所有可用软件包列表
             
             [root@localhost yum.repos.d]# yum list 包名 
             #查询单个软件包
             
             [root@localhost yum.repos.d]# yum search 关键字 
             #搜索服务器上所有和关键字相关的软件包
             
             [root@localhost yum.repos.d]# yum info samba 
             #查询 samba 软件包的信息
             Available Packages  还没有安装
             Name : samba  包名
             Arch : i686  适合的硬件平台
             Version : 3.5.10 版 本
             Release : 125.el6  发布版本
             Size : 4.9 M  大小
             Repo : c6-media  在光盘上
             ...省略部分输出...
             ```

             ###### 安装升级与卸载

             ```shell
             [root@localhost yum.repos.d]# yum -y install 包名
             [root@localhost yum.repos.d]# yum -y update 包名
             选项:
             -y: 自动回答 yes
             [root@localhost yum.repos.d]# yum remove 包名
             #除非你确定卸载的软件的依赖包不会对系统产生影响，否则不要执行 yum 的卸载， 因为很有可能在卸载软件包的同时卸载的依赖包也是重要的系统文件，这就有可能导致系统崩溃
             ```

          4. ##### yum组管理命令

             ```shell
              [root@localhost ~]# yum grouplist 
              #列出所有可用的软件组列表
              [root@localhost ~]# yum groupinfo 软件组名 
              #列出软件组中包含的软件
              [root@localhost ~]# yum groupinstall 软件组名 
              #安装指定软件组，组名可以由 grouplist 查询出来
              [root@localhost ~]# yum groupremove 软件组名 
              #卸载指定软件组
             ```

   3. ## 源码包安装

      1. ### 安装过程

         #### (1)下载软件包

         #### (2)解压缩

         #### (3)进入解压目录

         #### (4)./configure，编译前准备，其目的是：

         + ##### 在安装之前需要检测系统环境是否符合安装要求

         + ##### 定义需要的功能选项。“./configure”支持的功能选项较多，可以执行“./configure--help”命令查询其支持的功能。一般都会通过“./configure --prefix=安装路径”来指定安装路径

         + ##### 把系统环境的检测结果和定义好的功能选项写入Makefile文件，后续的编译和安装需要依赖这个文件的内容

         ##### ***需要注意的是，configure 不是系统命令，而是源码包软件自带的一个脚本程序，所以必须采用
         “./configure”方式执行(“./”代表在当前目录下)***

         #### (5)make，编译，调用 gcc 编译器，并读取 Makefile 文件中的信息进行系统软件编译。编译的目的就是把 源码程序转变为能被 Linux 识别的可执行文件，这些可执行文件保存在当前目录下

         #### (6)make clean，清空编译内容(非必需步骤)，果在“./configure”或“make”编译中报错，那么我们在重新执行命令前一定要记得执行 makeclean 命令，它会清空 Makefile 文件或编译产生的“.o”头文件

         #### (7)make install，编译安装，这才是真正的安装过程，一般会写清楚程序的安装位置。如果忘记指定安装目录，则可以把这个 命令的执行过程保存下来，以备将来删除使用

         #### (8)删除，源码包没有删除命令，如果需要删除，直接删除安装目录即可

      2. ### 打入补丁

         1. #### 补丁的生成

         ```shell
         [root@localhost ~]# diff 选项 old new #比较 old 和 new 文件的不同
         选项:
         -a 将任何文档当做文本文档处理
         -b 忽略空格造成的不同
         -B 忽略空白行造成的不同
         -I 忽略大小写造成的不同
         -N 当比较两个目录时，如果某个文件只在一个目录中，则在另一个目录中视作空文件
         -r 当比较目录时，递归比较子目录
         -u 使用同一的输出格式
         
         
         例1：创建两个稍有不同的新旧文件
         [root@localhost ~]# mkdir test #建立测试目录
         [root@localhost ~]# cd test #进入测试目录
         [root@localhost test]# vi old.txt our
         school
         is
         atguigu
         #文件 old.txt，为了一会输出便于比较，每行分开 
         [root@localhost test]# vi new.txt
         our
         school
         is
         atguigu
         in
         Beijing
         #文件 new.txt
         
         例2：比较下两个文件的不同，并生成补丁文件“txt.patch”
         [root@localhost test]# diff -Naur /root/test/old.txt /root/test/new.txt > txt.patch 
         #比较两个文件的不同，同时生成 txt.patch 补丁文件
         [root@localhost test]# vi txt.patch
         #查看下这个文件
         --- /root/test/old.txt 2012-11-23 05:51:14.347954373 +0800 
         #前一个文件
         +++ /root/test/new.txt 2012-11-23 05:50:05.772988210 +0800 
         #后一个文件
         @@ -2,3 +2,5 @@ school
         is
         atguigu
         +in 
         +beijing
         #后一个文件比前一个文件多两行(+表示)
         ```

         2. #### 打入补丁

         ```shell
         patch –pn < 补丁文件 
         #按照补丁文件进行更新
         选项:
         -pn n 为数字。代表按照补丁文件中的路径，指定更新文件的位置。
         ```

         ##### “-pn”不好理解，我们说明下。补丁文件是要打入旧文件的，但是你当前所在的目录和补丁文 件中的记录的目录是不一定匹配的，所以就需要“-pn”来同步两个目录。比如我当前是在“/root/test”目录中(我要打补丁的旧文件就在当前目录下)，补丁文件中记 录的文件目录为“/root/test/old.txt”，这时如果写入“-p1”(在补丁文件目录中取消一级目录) 那么补丁文件就会打入“/root/test/root/test/old.txt”文件中，这显然是不对的。那如果写入的 是“-p2”(在补丁文件目录中取消二级目录)那么补丁文件打入的就是“/root/test/test/old.txt”, 这显然也不对。如果写入的是“-p3”(在补丁文件目录中取消三级目录)那么补丁文件就是打入的 “/root/test/old.txt”，我们的 old.txt 文件就在这个目录下，所以就应该是“-p3”。 那么我们更新下“old.txt”文件，命令如下：

         ```shell
         [root@localhost test]# patch -p3 < txt.patch patching file old.txt
         #给 old.txt 文件打补丁
         [root@localhost test]# cat old.txt 
         #查看下 old.txt 的内容吧。
         our
         school
         is
         atguigu
         in
         Beijing
         #多出来了 in Beijing 两行
         ```

