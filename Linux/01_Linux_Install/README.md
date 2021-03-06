# ***Linux系统安装***

1. ## VMware虚拟机安装与使用

   ### VMware简介：VMware是一个虚拟PC的软件，可以在现有的操 作系统上虚拟出一个新的硬件环境，相当于模拟 出一台新的PC ，以此来实现在一台机器上真正 同时运行两个独立的操作系统 。

   ###  VMware主要特点：

   + #### 不需要分区或重新开机就能在同一台PC上使用两种以上的操作系统

   + #### 本机系统可以与虚拟机系统网络通信

   + #### 可以设定并且随时修改虚拟机操作系统的硬件环境

   ### 建议的VMware配置：

   + #### CPU建议主频为1GHz以上

   + #### 内存建议1GB以上

   + #### 硬盘建议分区空闲空间8GB以上

   ### 虚拟机网络设置

   | 连接方式 | 连接网卡     | 是否能连接本机 | 是否能连接局域网 | 是否能连接公网 |
   | -------- | ------------ | -------------- | ---------------- | -------------- |
   | 桥接     | 本地真实网卡 | 可以           | 可以             | 可以           |
   | NAT      | VMnet8       | 可以           | 不可用           | 可用           |
   | 仅主机   | VMnet1       | 可以           | 不能             | 不能           |

2. ## 系统分区

   ### 磁盘分区：**磁盘分区**是使用分区编辑器（partition editor）在磁盘上 划分几个逻辑部分。碟片一旦划分成数个分区 （Partition），不同类的目录与文件可以存储进不同的分区

   ### 两种分区表形式：

   + #### MBR分区表：最大支持2.1TB硬盘，大于2.1T的部分不会被识别，最多支持4个分区，今后会逐渐被淘汰

   + #### GPT分区表(全局唯一标示分区表)：GPT支持9.4ZB 硬盘(1ZB=1024PB，1PB=1024EB，1EB=1024TB)。 理论上支持的分区数没有限制，但windows限制128个主分区

   ### MBR分区类型：

   + #### 主分区：最多只能有4个，没块硬盘必须要有至少1个主分区

   + #### 扩展分区：最多只能有1个，主分区加扩展分区最多有4个，不能写入数据，只能包含逻辑分区

   + #### 逻辑分区

   ### 格式化（高级格式化）又称逻辑格式化，它是指根据用户 选定的文件系统（如FAT16、FAT32、NTFS、EXT2、 EXT3、EXT4等），在磁盘的特定区域写入特定数据，在 分区中划出一片用于存放文件分配表、目录表等用于文件 管理的磁盘空间。格式化的主要作用是写入文件系统，清空数据至少附带作用。

   ### 硬件设备文件名

   | 硬件              | 设备文件名           |
   | ----------------- | -------------------- |
   | IDE硬盘           | /dev/hd[a-d]         |
   | SCSI/SATA/USB硬盘 | /dev/sd[a-p]         |
   | 光驱              | /dev/cdrom或/dev/sr0 |
   | 软盘              | /dev/fd[0-1]         |
   | 打印机(25针)      | /dev/lp[0-2]         |
   | 打印机(USB)       | /dev/usb/lp[0-15]    |
   | 鼠标              | /dev/mouse           |

   ### 挂载：

   + #### 必须分区

     - ##### / （根分区）

     - ##### swap分区 （交换分区），如果真实内存小于4GB，swap位内存的两倍，如果真实内存大于4GB，swap和内存一致，实验环境，不大于2GB

   + #### 推荐分区

     - ##### /boot（启动分区，1GB）

   + #### 常用分区

     - ##### /home（用于文件服务器）

     - ##### /www（用于Web服务器）

3. ## 系统安装

   ### 安装日志

   + #### /root/install.log:存储了安装在系统中的软件包及其版本信息

   + #### /root/install.log.syslog:存储了安装过程中留下的事件记录

   + #### /root/anaconda-ks.cfg:以Kickstart配置文件的格式记录安装过程 中设置的选项信息

   ### 初次开机配置IP地址

   ```
   [root@localhost ~]# setup
   #通过setup工具设置IP地址，注意激活onboot=yes
   
   [root@localhost ~]# service network restart
   #重启网络服务
   ```

4. ## 总结

   + ### 分区：把大硬盘分为小的逻辑分区

   + ### 格式化：写入文件系统

   + ### 分区设备文件名：给每个分区定义设备文件名

   + ### 挂载：给每个分区分配挂载点

