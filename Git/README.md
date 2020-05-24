# ***笨方法学Git***

1. ## 设置

   + ### 目的

     #### 设置 Git 以便准备开始工作

   + ### 设置姓名和邮箱

     #### 执行下列命令能够让 Git 知道你的姓名和邮箱

     ```shell
     git config --global user.name "Your Name"
     git config --global user.email "your_email@whatever.com"
     ```

   + ### 设置行尾选项

     #### Mac/Unix 用户:

     ```shell
     git config --global core.autocrlf input
     git config --global core.safecrlf true
     ```

     #### Windows 用户:

     ```shell
     git config --global core.autocrlf true
     git config --global core.safecrlf true
     ```

2. ## 查看设置

   #### config 配置有system级别 global（用户级别） 和local（当前仓库）三个 设置先从system-> global-> local  底层配置会覆盖顶层配置 分别使用--system/global/local 可以定位到配置文件

   + ### 查看系统配置

     ```shell
     git config --system --list
     ```

   + ### 查看当前用户配置

     ```shell
     git config --global --list
     ```

   + ### 查看当前仓库配置

     ```shell
     git config --local  --list
     ```

3. ## 创建项目

   + ### 创建工作目录

     #### 选择自己喜欢的位置,创建工作目录

     ```shell
     mkdir learn_git
     cd learn_git
     touch LearnGit.txt
     ```

   + ### 创建仓库

     #### 现在有一个包含单文件的目录。要从该目录创建 Git 仓库，需执行 `git init` 命令

     ```shell
     git init
     ```

   + ### 添加更改暂存区并提交到仓库

     #### 现在把新增的LearnGit.txt 先添加到暂存区再提交到本地仓库中

     ```shell
     git add LearnGit.txt
     git commit -m "初始化仓库"
     ```

     #### 可以看到

     ```shell
     [master (root-commit) 7a05652] 初始化仓库
      1 file changed, 1 insertion(+)
      create mode 100644 LearnGit.txt
     ```

4. ## 检查状态

   #### 使用 `git status` 命令检查仓库的当前状态

   ```shell
   git status
   ```

   #### 可以看到 

   ```shell
   On branch master
   nothing to commit, working tree clean
   ```

   #### `status` 命令报告没有要提交的内容。这意味着仓库包含工作目录的所有状态。没有待解决的更改要记录

5. ## 进行更改

   + ### 工作区对文件进行更改

     ```shell
     echo "第一次更改" >> LearnGit.txt
     ```

   + ### 重新检查工作区的状态

     ```shell
     git status
     ```

     #### 可以看到

     ```shell
     On branch master
     Changes not staged for commit:
       (use "git add <file>..." to update what will be committed)
       (use "git restore <file>..." to discard changes in working directory)
     	modified:   LearnGit.txt
     
     no changes added to commit (use "git add" and/or "git commit -a")
     ```

     ####  Git 知道 `LearnGit.txt` 文件已被修改，但它还没有被通知到。另外要注意的是状态信息提示你接下来需要做什么。如果你想要将这些更改添加到仓库，那么使用 `git add` 命令。否则，使用 `git restore 命令放弃更改

6. ## 暂存更改

   #### 告诉 Git 暂存更改，并检查状态

   ```shell
   git add LearnGit.txt
   git status
   ```

   #### 可以看到

   ```shell
   On branch master
   Changes to be committed:
     (use "git restore --staged <file>..." to unstage)
   	modified:   LearnGit.txt
   ```

   #### 对 `LearnGit.txt` 文件的更改已被暂存。这意味着 Git 现在了解这些更改，但还没有永久记录到仓库中。下面的提交操作将包含暂存的更改；如果你决定不提交更改，那么 `status` 命令将提醒你使用 `git restore` 命令取消暂存更改

7. ## 暂存与更改

   #### 在 Git 中分开暂存是直到你需要使用源码控制处理的协调解决方法。你可以继续对工作目录做更改，然后当你想要与源码控制交互时，Git 允许你使用微小的提交来精确地记录所作的更改

   #### 假设你编辑了三个文件（`a.txt`、`b.txt` 及 `c.txt`）。现在你想提交所有更改，但你想要 `a.txt` 和 `b.txt` 中的更改作为单个提交，而 `c.txt` 的更改与前两个文件在逻辑上不相关，那么应该分开提交

   #### 可以使用以下命令

   ```shell
   git add a.txt
   git add b.txt
   git commit -m "Changes for a and b"
   
   git add c.txt
   git commit -m "Unrelated change to c"
   ```

   #### 通过分开暂存和提交，能更容易地微调每一个提交

8. ## 提交更改

   #### 关于暂存谈得差不多了。让我们提交已暂存的内容到仓库

   #### 先前使用 `git commit` 命令提交 `LearnGit.txt` 文件的初始版本到仓库时，在命令行中的 `-m` 选项可以包含注释。`commit` 命令将允许你交互式地编辑提交的注释

   #### 从命令行忽略 `-m` 选项，那么 Git 将带你到所选的编辑器中。

   ```shell
   git commit
   ```

   #### 在编辑器中你会看到如下提示，按要求输入提交信息然后保存退出

   ```shell
   提交第三次更改
   # Please enter the commit message for your changes. Lines starting
   # with '#' will be ignored, and an empty message aborts the commit.
   #
   # On branch master
   # Changes to be committed:
   #       modified:   LearnGit.txt
   #
   ```

   ```shell
   [master 1ff24a5] 提交第三次更改
    1 file changed, 1 insertion(+)
   ```

   #### 再次查看状态

   ```shell
   git status
   On branch master
   nothing to commit, working tree clean
   ```

9. ## 更改而并非文件

   #### Git 专注于文件的更改而非文件本身。当你说 `git add file` 时，你并非在告诉 Git 要添加文件到仓库。而是说 Git 应当对文件的当前状态做记录以便稍后提交

   + ### 初次更改并添加到暂存区

     ```shell
     echo "多次更改的第一次" >> LearnGit.txt
     git add LearnGit.txt
     ```

   + ### 第二次更改不添加到暂存区

     ```shell
     echo "多次更改的第二次" >> LearnGit.txt
     ```

     #### 检查状态

     ```shell
     git status
     On branch master
     Changes to be committed:
       (use "git restore --staged <file>..." to unstage)
     	modified:   LearnGit.txt
     
     Changes not staged for commit:
       (use "git add <file>..." to update what will be committed)
       (use "git restore <file>..." to discard changes in working directory)
     	modified:   LearnGit.txt
     ```

     #### 注意 `LearnGit.txt` 在状态中被列了两次。第一次更改已被暂存，且准备提交。第二次更改还未暂存。如果你现在提交，那么第二次更改不会保存到仓库中

   + ### 第一次提交更改

     #### 提交暂存的更改，然后重新检查状态

     ```shell
     git commit -m "多次更改的第一次提交"
     git status
     On branch master
     Changes not staged for commit:
       (use "git add <file>..." to update what will be committed)
       (use "git restore <file>..." to discard changes in working directory)
     	modified:   LearnGit.txt
     ```

     #### `status` 命令将告诉你 `LearnGit.txt` 还有未记录的更改，且不在暂存区

   + ### 第二次更改暂存

     ```shell
     git add .
     git status
     On branch master
     Changes to be committed:
       (use "git restore --staged <file>..." to unstage)
     	modified:   LearnGit.txt
     ```

     #### 使用当前目录（.）作为要添加的文件。这是一种添加当前目录及其子目录下所有更改文件的惯用方式。但因为它添加所有东东，所以在做 `add .` 前检查状态是一个好主意，从而确信你没有添加不想要的文件。但为了安全，在余下的章节中我们将继续直接添加文件

     #### 可以看到现在第二次已经暂存，且准备提交

   + ### 第二次提交更改

     ```shell
     git commit -m "多次更改的第二次提交"
     ```

10. ## 历史记录

   + ### 列表展示

     #### `git log` 命令能够获得已做过的更改清单

     ```shell
     git log
     commit d3e742c49b486100086158aa89ac7d59ee09ee65 (HEAD -> master)
     Author: undermoonoldman <undermoonoldman@gmail.com>
     Date:   Fri May 22 16:27:51 2020 +0800
     
         多次更改的第二次提交
     
     commit 955b9d27e40bdef58f980c542fb17a467b117b98
     Author: undermoonoldman <undermoonoldman@gmail.com>
     Date:   Fri May 22 15:50:48 2020 +0800
     
         多次更改的第一次提交
     
     commit 1ff24a5236c2409c4263c1fa0917d47afb495142
     Author: undermoonoldman <undermoonoldman@gmail.com>
     Date:   Fri May 22 15:15:24 2020 +0800
     
         提交第三次更改
     
     commit f6070249f7bf56b00f4c7b3c7c1381527790c171
     Author: undermoonoldman <undermoonoldman@gmail.com>
     Date:   Fri May 22 15:13:11 2020 +0800
     
         第二次更改
     
     commit d2652e106be3d7ad6135e745d5d472769760f350
     Author: undermoonoldman <undermoonoldman@gmail.com>
     Date:   Fri May 22 14:49:16 2020 +0800
     
         执行第一次更改
     
     commit 7a05652420a84d47a693bae1ee3f8c43ff6ddd0f
     Author: undermoonoldman <undermoonoldman@gmail.com>
     Date:   Fri May 22 10:42:45 2020 +0800
     ```

   + ### 单行展示

     #### 可以控制 `log` 命令要精确显示的内容

     ```shell
     git log --pretty=oneline
     d3e742c49b486100086158aa89ac7d59ee09ee65 (HEAD -> master) 多次更改的第二次提交
     955b9d27e40bdef58f980c542fb17a467b117b98 多次更改的第一次提交
     1ff24a5236c2409c4263c1fa0917d47afb495142 提交第三次更改
     f6070249f7bf56b00f4c7b3c7c1381527790c171 第二次更改
     d2652e106be3d7ad6135e745d5d472769760f350 执行第一次更改
     7a05652420a84d47a693bae1ee3f8c43ff6ddd0f 初始化仓库
     
     # log 命令有许多选项用来选择显示哪个条目
     git log --pretty=oneline --max-count=2
     git log --pretty=oneline --since='5 minutes ago'
     git log --pretty=oneline --until='5 minutes ago'
     git log --pretty=oneline --author=<your name>
     git log --pretty=oneline --all
     ```

   + ### 美化

     #### 如果我只想看自己所作的更改，那么我将添加 `--author=undermoonoldman`

     ```shell
     git log --author=undermoonoldman --all --pretty=format:'%h %cd %s (%an)' --since='7 days ago'
     d3e742c Fri May 22 16:27:51 2020 +0800 多次更改的第二次提交 (undermoonoldman)
     955b9d2 Fri May 22 15:50:48 2020 +0800 多次更改的第一次提交 (undermoonoldman)
     1ff24a5 Fri May 22 15:15:24 2020 +0800 提交第三次更改 (undermoonoldman)
     f607024 Fri May 22 15:13:11 2020 +0800 第二次更改 (undermoonoldman)
     d2652e1 Fri May 22 14:49:16 2020 +0800 执行第一次更改 (undermoonoldman)
     7a05652 Fri May 22 10:42:45 2020 +0800 初始化仓库 (undermoonoldman)
     
     # 为了美观，工作时可以使用下列日志格式
     git log --pretty=format:'%h %ad | %s%d [%an]' --graph --date=short
     * d3e742c 2020-05-22 | 多次更改的第二次提交 (HEAD -> master) [undermoonoldman]
     * 955b9d2 2020-05-22 | 多次更改的第一次提交 [undermoonoldman]
     * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
     * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
     * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
     * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
     # --pretty="..." 定义输出的格式
     # %h 是提交 hash 的缩写
     # %d 是提交的装饰（如分支头或标签）
     # %ad 是创作日期
     # %s 是注释
     # %an 是作者姓名
     # --graph 使用 ASCII 图形布局显示提交树
     # --date=short 保留日期格式更好且更短
     ```

   11. ## 别名

       #### 每个仓库的Git配置文件都放在`.git/config`文件中，`git status`、`git add`、`git commit`、`git checkout` 是非常常用的命令，因此对它们进行缩写十分有用

       ```shell
       [alias]
         co = checkout
         ci = commit
         st = status
         br = branch
         hist = log --pretty=format:'%h %ad | %s%d [%an]' --graph --date=short
         type = cat-file -t
         dump = cat-file -p
       ```

       #### 或者使用命令添加别名，`--global`参数是全局参数，也就是这些命令在这台电脑的所有Git仓库下都有用，如果不加，那只针对当前的仓库起作用

       ```shell
       git config --global alias.co checkout
       git config --global alias.ci commit
       git config --global alias.br branch
       ```

   12. ## 切换到旧版本

       + ### 获得先前版本的哈希

         ```shell
         git hist
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (HEAD -> master) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

       + ### 挑选一个版本切换过去

         ```shell
         git checkout f607024
         Note: switching to 'f607024'.
         
         You are in 'detached HEAD' state. You can look around, make experimental
         changes and commit them, and you can discard any commits you make in this
         state without impacting any branches by switching back to a branch.
         
         If you want to create a new branch to retain commits you create, you may
         do so (now or later) by using -c with the switch command. Example:
         
           git switch -c <new-branch-name>
         
         Or undo this operation with:
         
           git switch -
         
         Turn off this advice by setting config variable advice.detachedHead to false
         
         HEAD is now at f607024 第二次更改
         ```

         #### Git 中的“detached HEAD”信息意味着 HEAD (Git 跟踪当前目录应当匹配的那部分)是直接指向提交而非分支。在你没有切换到不同的分支时，这种状态只会记得已经提交的更改。一旦你检出了新的分支或标签，分离的提交将被丢弃 (因为 HEAD 已经移走)。如果你想要保存在分离状态的提交，那么你需要创建分支来记住提交

       + ### 回到在 master 分支中的最新版本

         ```shell
         git checkout master
         Previous HEAD position was f607024 第二次更改
         Switched to branch 'master'
         ```

         #### `master` 是默认分支的名称。通过名称检出分支，你能够回到该分支的最新版本

   13. ## 给版本打标签

       + ### 标记当前版本

         ```shell
         git tag v1
         ```

         #### 现在你可以引用程序的当前版本为 v1

       + ### 标记先前版本

         #### 要标记当前版本之前的版本为 v1-beta。首先我们需要检出先前的版本。代替查询哈希，我们将使用 `^` 来表示“v1 的父提交”。如果使用 `v1^` 表示法遇到问题，可以试试 `v1~1`，这将引用相同的版本。该表示法意为“v1 的第一个祖先提交”

         ```shell
         git checkout v1^
         Note: switching to 'v1^'.
         
         You are in 'detached HEAD' state. You can look around, make experimental
         changes and commit them, and you can discard any commits you make in this
         state without impacting any branches by switching back to a branch.
         
         If you want to create a new branch to retain commits you create, you may
         do so (now or later) by using -c with the switch command. Example:
         
           git switch -c <new-branch-name>
         
         Or undo this operation with:
         
           git switch -
         
         Turn off this advice by setting config variable advice.detachedHead to false
         
         HEAD is now at 955b9d2 多次更改的第一次提交
         ```

         #### 现在把它标记成为 v1-beta

         ```shell
         git tag v1-beta
         ```

         #### 现在就可以按标签名在两个版本之间切换了

       + ### 使用 tag 命令查看标签

         ```shell
         git tag
         v1
         v1-beta
         ```

       + ### 查看日志中的标签

         ```shell
         git hist master --all
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (HEAD -> master, tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

         ####  在日志输出中看到与分支名称（master）一起列出了两
         个标签（v1 和 v1-beta），而且 HEAD 显示你当前检出的提交
         （此刻是 v1）

   14. ## 撤销工作目录的更改

       + ### 更改工作区内容

         ```shell
         echo "测试撤销工作区更改" >> LearnGit.txt
         ```

       + ### 检查工作目录状态

         ```shell
         git status
         On branch master
         Changes not staged for commit:
           (use "git add <file>..." to update what will be committed)
           (use "git restore <file>..." to discard changes in working directory)
         	modified:   LearnGit.txt
         
         no changes added to commit (use "git add" and/or "git commit -a")
         ```

         #### 看到 `LearnGit.txt` 已被修改，但还没有暂存

       + ### 还原工作目录中的更改

         ```shell
         git checkout LearnGit.txt
         Updated 1 path from the index
         ```

       + ### 再次查看工作目录状态

         ```shell
         git status
         On branch master
         nothing to commit, working tree clean
         ```

         #### `status` 命令显示在工作目录中没有未暂存的更改

   15. ## 撤销已暂存的更改

       + ### 更改工作区内容并暂存

         ```shell
         echo "测试撤销暂存区更改" >> LearnGit.txt
         git add LearnGit.txt
         ```

       + ### 查看状态

         ```shell
         git status
         On branch master
         Changes to be committed:
           (use "git restore --staged <file>..." to unstage)
         	modified:   LearnGit.txt
         ```

         #### `status` 输出显示更改已被暂存且准备提交

       + ### 恢复已暂存的更改

         #### 幸运的是 `status` 输出告诉我们取消暂存更改时需要做什么

         ```shell
         git restore --staged LearnGit.txt
         
         git status
         On branch master
         Changes not staged for commit:
           (use "git add <file>..." to update what will be committed)
           (use "git restore <file>..." to discard changes in working directory)
         	modified:   LearnGit.txt
         ```

         #### `restore` 命令重置 HEAD 中暂存区的内容。这将清除我们已经暂存的更该

         #### 使用一次`restore` 命令后更改从暂存区退回到了工作目录。所以想要在工作目录中也取消更改。我们可以使用之前实验中的 `checkout` 命令来从工作目录移除不想要的更改，或者再次使用 `restore`命令

         ```shell
         # 使用 restore 命令（不用添加 --staged 选项）
         git restore LearnGit.txt
         
         # 或者使用 checkout 命令
         git checkout LearnGit.txt
         ```

   16. ## 撤销已提交的更改

       + ### 更改并提交

         ```shell
         echo "测试撤销已提交的更改" >> LearnGit.txt
         git add LearnGit.txt
         git commit -m "测试撤销已提交的更改"
         [master 7505ed7] 测试撤销已提交的更改
          1 file changed, 1 insertion(+)
         ```

       + ### 创建一个还原提交

         #### 要撤销已提交的更改，我们需要创建一个提交来移除由不想要的提交所引入的更改

         ```shell
         git revert HEAD
         # 输入该命令后会进入到编辑页面，完成编辑并退出后完成还原提交
         [master 3d5da2d] Revert "测试撤销已提交的更改"
          1 file changed, 1 deletion(-)
         ```

       + ### 查看日志

         ```shell
         git hist
         * 3d5da2d 2020-05-23 | Revert "测试撤销已提交的更改" (HEAD -> master) [undermoonoldman]
         * 7505ed7 2020-05-23 | 测试撤销已提交的更改 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

         #### 可以看到，还原操作也被作为了一个提交

         #### 使用这种方法有时可能需要解决冲突。如果是在公开分享的远程仓库上则使用分支更加安全

   17. ## 从分支移除提交

       #### 上一节的 `revert` 是一个让我们撤销仓库中的任意提交的强大命令。然而，原始提交和“撤销”提交在历史记录中都可见（使用 `git log` 命令）

       #### 如果有一个“收回”命令能允许我们假装不正确的提交从未发生过该多好啊。“收回”命令甚至还会阻止错误的提交在 `git log` 历史中的显示。这就像错误的提交从未发生过一样

       + ### 重置命令介绍

         #### `reset` 命令，并用它来重置暂存区

         #### 当给定提交引用（如哈希、分支或标签名）时，`reset` 命令将：

         1. ##### 重写当前分支到指向的特定提交

         2. ##### 重置暂存区到匹配特定的提交（可选）

         3. ##### 重置工作目录到匹配特定的提交（可选）

       + ### 查看历史

         ```shell
         git hist
         * 3d5da2d 2020-05-23 | Revert "测试撤销已提交的更改" (HEAD -> master) [undermoonoldman]
         * 7505ed7 2020-05-23 | 测试撤销已提交的更改 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

         #### 目标是使用 `reset` 来移除最近的两次提交，最终的效果就是回到 v1 版本

       + ### 标记最新版本

         #### 在我们移除提交前，让我们使用一个标签来标记最新的提交以便能够再次找到它

         ```shell
         git tag oops
         ```

       + ### 重置回到之前版本

         ```shell
         git reset --hard v1
         git hist
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (HEAD -> master, tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

         #### 我们的 master 分支现在指到 v1 提交，并且最新的两次提交已经不在分支中。`--hard` 参数表示应当更新工作目录以便与新的分支头保持一致

       + ### 被丢弃的版本去了哪里

         #### 被丢弃的版本去了哪里？结果是提交仍然在仓库中。事实上，我们仍然能够引用它们。记得在本实验开始我们使用标签“oops”标记了还原的提交。让我们看看所有的提交

         ```shell
         git hist --all
         * 3d5da2d 2020-05-23 | Revert "测试撤销已提交的更改" (tag: oops) [undermoonoldman]
         * 7505ed7 2020-05-23 | 测试撤销已提交的更改 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (HEAD -> master, tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

         #### 我们看到错误的提交并没有消失。它们仍然在仓库中。它们只是不再列到 master 分支中。如果我们没有标记它们，它们依然在仓库中，但除了使用哈希值外没有别的方法引用它们。未引用的提交保留在仓库中，一直到系统运行垃圾回收软件时

       + ### 重置操作的危险性

         #### 在本地分支上重置一般是安全的。任何“事故”通常都能通过重置到想要的提交来恢复

         #### 然而，如果分支在共享的远程仓库上，那么重置可能使其他用户共享的分支混乱

   18. ## 移除弃用的版本标签

       #### oops 标签已经实现其目的。让我们移除它，以便它引用的提交被作为垃圾回收

       ```shell
       git tag -d oops
       Deleted tag 'oops' (was 3d5da2d)
       
       git hist --all
       * d3e742c 2020-05-22 | 多次更改的第二次提交 (HEAD -> master, tag: v1) [undermoonoldman]
       * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
       * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
       * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
       * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
       * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
       ```

       #### 在仓库中不再列出 oops 标签了

   19. ## 修改已有提交

       #### 有时会出现需要修改已有提交的情况

       + ### 执行更改并提交

         ```shell
         echo "测试修改已有提交" >> LearnGit.txt
         git add LearnGit.txt
         git commit -m "测试修改提交之前"
         [master 4861a3d] 测试修改提交之前
          1 file changed, 1 insertion(+)
         ```

       + ### 修改之前的提交

         ```shell
         echo "测试修改已有提交完成" >> LearnGit.txt
         git add LearnGit.txt
         git commit --amend -m "测试修改提交之后"
         [master 8b659f1] 测试修改提交之后
          Date: Sat May 23 18:26:05 2020 +0800
          1 file changed, 2 insertions(+)
          
         git hist
         * 8b659f1 2020-05-23 | 测试修改提交之后 (HEAD -> master) [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```

         #### 就这样，前一次的提交被修改了，历史记录中只显示最新一次的修改提交信息

         #### 通过重置分支到某个提交并重新提交新的更改，可以实现相同的效果。

   20. ## 文件移动

       + ### 使用 git mv 命令来移动文件

         ```shell
         mkdir moved
         git mv LearnGit.txt moved
         git status
         On branch master
         Changes to be committed:
           (use "git restore --staged <file>..." to unstage)
         	renamed:    LearnGit.txt -> moved/LearnGit.txt
         ```

         #### 通过使用 Git 来移动文件，我们通知了 Git 两件事：

         1. ##### 文件 `LearnGit.txt` 已被删除

         2. ##### 文件 `moved/LearnGit.txt` 已被创建

         #### 这些信息被立即暂存并准备提交。`git status` 命令将报告文件已被移动

       + ### 移动文件的另一种方法

         #### 使用系统命令移动文件与使用 git 命令移动文件效果是一样的

         ```shell
         mkdir moved
         mv mv LearnGit.txt moved
         git add moved/LearnGit.txt
         git rm LearnGit.txt
         ```

       + ### 提交此次移动操作

         ```shell
         git commit -m "测试git mv 命令"
         [master 200c2a7] 测试git mv 命令
          1 file changed, 0 insertions(+), 0 deletions(-)
          rename LearnGit.txt => moved/LearnGit.txt (100%)
         ```

   21. ## Git 内幕 : .git 目录

       #### 查看 .git 目录内容

       ```shell
       ls -C .git
       COMMIT_EDITMSG ORIG_HEAD      description    hooks          info           objects
       HEAD           config         fork-settings  index          logs           refs
       ```

       + ### 对象存储

         ```shell
         ls -C .git/objects
         00   1a   1f   29   46   48   4f   75   8b   93   96   c6   d2   ee   f9   pack
         0e   1b   20   3d   47   4b   6a   7a   91   95   a8   d1   d3   f6   info
         ```

         #### 我们可以看到一串包含两个字符名称的目录。目录名称是 Git 中对象存储的 sha1 哈希的开头两个字符

       + ### 深入对象存储

         ```shell
         ls -C .git/objects/00
         ef8069e47bd073f15becbdca69be622e667e19
         ```

         #### 我们应当看到一些具有 38 个字符名称的文件。这是 Git 中包含对象存储的文件。这些文件已被压缩和编码，所以直接查看它们的内容并没有什么用处

       + ### 配置文件

         ```shell
         cat .git/config
         [core]
         	repositoryformatversion = 0
         	filemode = true
         	bare = false
         	logallrefupdates = true
         	ignorecase = true
         	precomposeunicode = true
         [alias]
           co = checkout
           ci = commit
           st = status
           br = branch
           hist = log --pretty=format:'%h %ad | %s%d [%an]' --graph --date=short
           type = cat-file -t
           dump = cat-file -p
         ```

         #### 这是项目级配置文件。在此的配置条目将覆盖你的主目录中 `.gitconfig` 文件中的配置条目

       + ### 分支与标签

         ```shell
         ls .git/refs
         heads tags
         
         ls .git/refs/heads
         master
         
         ls .git/refs/tags
         v1      v1-beta
         
         cat .git/refs/tags/v1
         d3e742c49b486100086158aa89ac7d59ee09ee65
         ```

         #### 标签子目录中的文件。每个文件都与你先前使用 `git tag` 命令所创建的标签相互对应。它的内容是绑定到标签的提交哈希

         #### `heads` 目录与此相似，但它是用于分支而非标签。现在我们只有一个分支，所以你在该目录中只会看到 master

       + ### HEAD 文件

         ```shell
         cat .git/HEAD
         ref: refs/heads/master
         ```

         #### HEAD 文件包含当前分支的引用。此刻它是对 master 的引用

   22. ## 直接处理 Git 对象

       #### 我们将浏览对象存储的结构。学习如何使用 SHA1 哈希来查找仓库中的内容

       + ### 查找最新的提交

         ```shell
         git hist --max-count=1
         * 6a03044 2020-05-23 | Revert "测试git mv 命令" (HEAD -> master) [undermoonoldman]
         ```

       + ### 转存最新的提交

         ```shell
         git cat-file -t 6a03044
         commit
         git cat-file -p 6a03044
         tree 0e3cc28beb5e093bbe0ca04dd3260d250eedd3ff
         parent 200c2a70ce6f1c7b748da260adff3483a44265fa
         author undermoonoldman <undermoonoldman@gmail.com> 1590233646 +0800
         committer undermoonoldman <undermoonoldman@gmail.com> 1590233646 +0800
         
         Revert "测试git mv 命令"
         
         This reverts commit 200c2a70ce6f1c7b748da260adff3483a44265fa.
         ```

         #### 如果你在别名实验中定义了 `type` 和 `dump` 别名，那么你可以输入 `git type` 和 `git dump`，而不是更长的 `cat-file` 命令

         #### 这是 `master` 分支头提交对象的转存结果。它看起来很像先前介绍的提交对象

       + ### 查找 Tree

         #### 我们可以转存提交中的目录树引用。这应当是我们项目中的文件的说明。使用上面所列“tree”那行的 SHA1 哈希

         ```shell
         git cat-file -p 0e3cc28beb5e093bbe0ca04dd3260d250eedd3ff
         100644 blob 475a113499794012f69e0412efcf990bfa89998f	LearnGit.txt
         ```

       + ### 查看文件

         ```shell
         git cat-file -p 475a113499794012f69e0412efcf990bfa89998f
         hello git!
         第一次更改
         第二次更改
         第三次更改
         多次更改的第一次
         多次更改的第二次
         测试修改已有提交
         测试修改已有提交完成
         ```

         #### 到此为止，我们直接从 Git 仓库查看了提交对象、树对象、以及 blob 对象

   23. ## 创建分支

       #### 有时需要开发新功能时，会新开一个独立的分支，与 master 隔离开来
   
     + ### 创建分支
     
       ```shell
       git checkout -b greet
       Switched to a new branch 'greet'
       
       git status
       On branch greet
       nothing to commit, working tree clean
       ```
     
       #### `git checkout -b ` 是 `git branch ` 及 `git checkout ` 的简写
     
     + ### 在 greet 分支执行修改并提交
     
       ```shell
       echo "在greet分支进行第一次新增" >> LearnGit.txt
       git add LearnGit.txt
       git commit -m "greet分支第一次修改"
       [greet e3c86de] greet分支第一次修改
        1 file changed, 1 insertion(+)
       ```
     
       #### 现在已经有了包含 1 个新提交的 greet 新分支
   
   24. ## 分支切换

       #### 查看版本可以发现有两个分支

       ```shell
       git hist --all
       * e3c86de 2020-05-24 | greet分支第一次修改 (HEAD -> greet) [undermoonoldman]
       * 6a03044 2020-05-23 | Revert "测试git mv 命令" (master) [undermoonoldman]
       * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
       * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
       * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
       * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
       * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
       * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
       * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
       * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
       ```

       + ### 切换到 master 分支

         ```shell
         git checkout master
         Switched to branch 'master'
         
         git status
         On branch master
         nothing to commit, working tree clean
         ```

         #### 通过查看状态，确实切换到了 master 分支

       + ### 回到 Greet 分支

         ```shell
         git checkout greet
         Switched to branch 'greet'
         
         git status
         On branch greet
         nothing to commit, working tree clean
         ```

   25. ## 制造冲突 : 在 master 中更改

       #### 当你更改 greet 分支时，其他人决定更新 master 分支，这时就会产生冲突

       + ### 切换到 master 分支

         ```shell
         git checkout master
         ```

       + ### 更新并提交

         ```shell
         echo "多分支时修改主分支制造冲突" >> LearnGit.txt
         git add LearnGit.txt
         git commit -m "多分支时更新主分支制造冲突"
         ```

   26. ## 查看分叉的分支

       #### 上节我们在创建 greet 分支后又修改了 master 分支并提交，这就造成了两条分叉的分支

       ```shell
       git hist --all
       * 185d357 2020-05-24 | 多分支时更新主分支制造冲突 (HEAD -> master) [undermoonoldman]
       | * e3c86de 2020-05-24 | greet分支第一次修改 (greet) [undermoonoldman]
       |/
       * 6a03044 2020-05-23 | Revert "测试git mv 命令" [undermoonoldman]
       * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
       * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
       * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
       * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
       * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
       * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
       * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
       * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
       ```

       #### 在此我们第一次有机会看到 `git hist` 中 `--graph` 选项的效果。添加 `--graph` 到 `git hist` 使它能够使用简单的 ASCII 字符来绘制提交树。我们可以看到两个分支（greet 和 master），并且 master 分支是当前的 HEAD。两个分支的共同祖先是“Revert 测试git mv 命令”提交

   27. ## 合并两条分叉的分支并解决冲突

       #### 合并将两个分支中的更改结合在一起。让我们回到 greet 分支，并将 master 合并过来

       ```shell
       git checkout greet
       git merge master
       Auto-merging LearnGit.txt
       CONFLICT (content): Merge conflict in LearnGit.txt
       Automatic merge failed; fix conflicts and then commit the result.
       ```

       #### 两条分支对同一个文件进行修改后，这时就需要我们来手动解决冲突，通常是修改文件内容使之一一条分支的版本为准

       #### 提交冲突解决

       ```shell
       git add LearnGit.txt
       git commit -m "解决合并主分支时的冲突"
       [greet bad4bad] 解决合并主分支时的冲突
        1 file changed, 1 insertion(+)
       ```

       #### 解决完冲突后，再次合并就可以成功了

   28. ## 变基演示及与合并的区别
   
       + ### 操作流程
   
         #### 将主分支与 greet 分支回退到没有冲突的版本，再与 greet 分支上做修改然后执行变基操作
   
       + ### 查看合并的效果图
   
         ```shell
         *   94355e9 2020-05-24 | Merge branch 'master' into greet (HEAD -> greet) [undermoonoldman]
         |\
         | * 185d357 2020-05-24 | 多分支时更新主分支制造冲突 (master) [undermoonoldman]
         * | e5ef6e0 2020-05-24 | 解决合并主分支时的冲突 [undermoonoldman]
         * | e3c86de 2020-05-24 | greet分支第一次修改 [undermoonoldman]
         |/
         * 6a03044 2020-05-23 | Revert "测试git mv 命令" [undermoonoldman]
         * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
         * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```
   
       + ### 回退 greet 分支
   
         ```shell
         git reset --hard e3c86de
         HEAD is now at e3c86de greet分支第一次修改
         # 这样 greet 分支就回退到合并前的状态了
         ```
   
       + ### 回退 master 分支
   
         ```shell
         git checkout master
         git reset --hard 6a03044
         HEAD is now at 6a03044 Revert "测试git mv 命令"
         # 这样 master 分支就退回到合并之前的状态了，且没有冲突需要解决
         ```
   
       + ### greet 分支进行修改并提交
   
         ```shell
         git checkout greet
         echo "在greet分支进行第二次新增" >> LearnGit.txt
         echo "在greet分支进行第三次新增" >> LearnGit.txt
         git add LearnGit.txt
         git commit -m "greet分支第二第三次修改"
         ```
   
       + ## 执行变基操作
   
         ```shell
         git checkout greet
         git rebase master
         git hist
         * 5b09fd4 2020-05-24 | greet分支第二第三次修改 (HEAD -> greet) [undermoonoldman]
         * e3c86de 2020-05-24 | greet分支第一次修改 [undermoonoldman]
         * 6a03044 2020-05-23 | Revert "测试git mv 命令" (master) [undermoonoldman]
         * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
         * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```
   
         #### 变基的最终结果与合并很相似。greet 分支现在包含它的全部更改以及来自 master 分支中的所有更改。然而，提交树却十分不同。greet 分支的提交树已被重写，以致 master 分支成为了其提交历史的一部分。这使提交链更加线性，且更易阅读
   
       + ### 何时变基，何时合并？
   
         #### 不要使用变基……
   
         #### 如果是公开且与其他人共享的分支，那么重写公开的共享分支将会搞砸团队中的其他会员
   
         #### 要是提交分支的精确历史重要（因为变基将重写提交历史）
   
         #### 根据上述准则，我会针对短期生命的本地分支使用变基，而对公开仓库的分支使用合并
   
   29. ## 合并更新回 master
   
       + ### 操作流程
   
         #### 我们已经保持 greet 分支与 master 最新（通过变基），现在让我们合并 greet 中的更改回到 master 分支
   
       + ### 合并 greet 到 master 中
   
         ```shell
         git checkout master
         git merge greet
         Updating 6a03044..5b09fd4
         Fast-forward
          LearnGit.txt | 3 +++
          1 file changed, 3 insertions(+)
         ```
   
         #### 因为 master 的头是 greet 分支头的直接祖先，所以 Git 可以做快进合并。当快进时，分支指针简单地前进到与 greet 分支相同的提交处，在快进合并中从来不会冲突
   
       + ### 回顾日志
   
         ```shell
         git hist
         * 5b09fd4 2020-05-24 | greet分支第二第三次修改 (HEAD -> master, greet) [undermoonoldman]
         * e3c86de 2020-05-24 | greet分支第一次修改 [undermoonoldman]
         * 6a03044 2020-05-23 | Revert "测试git mv 命令" [undermoonoldman]
         * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
         * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```
   
         #### greet 和 master 分支现在相同了
   
   30. ## 克隆仓库
   
       + ### 转到工作目录
   
         ```shell
         cd ..
         
         pwd
         /Users/arthur/GitLab
         
         ls
         learn_git
         ```
   
       + ### 创建 learn_git 仓库的克隆
   
         ```shell
         git clone learn_git cloned_learn_git
         Cloning into 'cloned_learn_git'...
         done.
         
         ls
         cloned_learn_git learn_git
         ```
   
         #### 在你的工作目录中现在应当有两个仓库：原始的“learn_git”仓库和新克隆的“cloned_learn_git”仓库
   
       + ### 查看历史
   
         ```shell
         git hist --all
         * 5b09fd4 2020-05-24 | greet分支第二第三次修改 (HEAD -> master, origin/master, origin/greet, origin/HEAD) [undermoonoldman]
         * e3c86de 2020-05-24 | greet分支第一次修改 [undermoonoldman]
         * 6a03044 2020-05-23 | Revert "测试git mv 命令" [undermoonoldman]
         * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
         * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         ```
   
         #### 看到新仓库的所有提交列表，而且它或多或少会匹配原始仓库的提交历史。仅有的差异体现在分支名称上，历史列表中看到 master 分支 (孤单的 HEAD)。而且你也将有许多奇怪的分支名称 (origin/master、origin/greet 及 origin/HEAD)
   
   31. ## 何为 orgin
   
       + ### 查看远程仓库
   
         ```shell
         git remote
         origin
         ```
   
         #### 继续查看有关 origin 的更多信息 :
   
         ```shell
         git remote show origin
         * remote origin
           Fetch URL: /Users/arthur/GitLab/learn_git
           Push  URL: /Users/arthur/GitLab/learn_git
           HEAD branch: master
           Remote branches:
             greet  tracked
             master tracked
           Local branch configured for 'git pull':
             master merges with remote master
           Local ref configured for 'git push':
             master pushes to master (up to date)
         ```
   
         #### 现在我们看到远程仓库“origin”简直就是原始的 learn_git 仓库。远程仓库典型地存在于可能是中央服务器的独立机器上。正如我们可以在此处看到的，它们可以指到同一机器上的仓库。关于名称“origin”没有什么特别的，对于主中央仓库（如果有的话）使用名称“origin”只是习惯约定而已
   
       + ### 查看分支
   
         ```shell
         git branch
         * master
         
         git branch -a
         * master
           remotes/origin/HEAD -> origin/master
           remotes/origin/greet
           remotes/origin/master
         ```
   
         #### Git 具有原始仓库的全部提交，但在远程仓库中的分支不会作为本地分支。如果我们想要 greet 分支，我们需要自行创建它
   
   32. ## 本地仓库同步远程仓库的更改
   
       + ### 修改远程仓库 lean_git 中的内容
   
         ```shell
         # 首先要切换到 learn_git 仓库所在的目录
         echo "远程仓库的修改测试" >> LearnGit.txt
         git add LearnGit.txt
         git commit -m "修改了clone仓库的远程仓库"
         [master 6082ec5] 修改了clone仓库的远程仓库
          1 file changed, 1 insertion(+)
         ```
   
       + ### cloned_learn_git 拉取远程仓库的更改内容
   
         ```shell
         git fetch
         remote: Enumerating objects: 5, done.
         remote: Counting objects: 100% (5/5), done.
         remote: Compressing objects: 100% (2/2), done.
         remote: Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
         Unpacking objects: 100% (3/3), 321 bytes | 160.00 KiB/s, done.
         From /Users/arthur/GitLab/learn_git
            5b09fd4..6082ec5  master     -> origin/master
            
         git hist --all
         * 6082ec5 2020-05-24 | 修改了clone仓库的远程仓库 (origin/master, origin/HEAD) [undermoonoldman]
         * 5b09fd4 2020-05-24 | greet分支第二第三次修改 (HEAD -> master, origin/greet) [undermoonoldman]
         * e3c86de 2020-05-24 | greet分支第一次修改 [undermoonoldman]
         * 6a03044 2020-05-23 | Revert "测试git mv 命令" [undermoonoldman]
         * 200c2a7 2020-05-23 | 测试git mv 命令 [undermoonoldman]
         * 8b659f1 2020-05-23 | 测试修改提交之后 [undermoonoldman]
         * d3e742c 2020-05-22 | 多次更改的第二次提交 (tag: v1) [undermoonoldman]
         * 955b9d2 2020-05-22 | 多次更改的第一次提交 (tag: v1-beta) [undermoonoldman]
         * 1ff24a5 2020-05-22 | 提交第三次更改 [undermoonoldman]
         * f607024 2020-05-22 | 第二次更改 [undermoonoldman]
         * d2652e1 2020-05-22 | 执行第一次更改 [undermoonoldman]
         * 7a05652 2020-05-22 | 初始化仓库 [undermoonoldman]
         
         # 查看 LearnGit.txt 的内容，之前在远程仓库所做的更该并没有合并到本地
         ```
   
         #### 此刻，仓库具有来自原始仓库的全部提交，但它并没有整合到克隆仓库的本地分支中，`git fetch` 命令的结果将从远程仓库取得新的提交，但它不会将这些提交合并到本地分支中
   
       + ### 将拉取的更改合并到本地 master
   
         ```shell
         git merge origin/master
         Updating 5b09fd4..6082ec5
         Fast-forward
          LearnGit.txt | 1 +
          1 file changed, 1 insertion(+)
         # 查看 learnGit.txt 的内容，之前在远程仓库所做的更改以及合并到本地
         ```
   
       + ### 使用单条命令拉取并合并远程更新内容
   
         #### git pull` 等价于 `git fetch` 和 `git merge
   
         ```shell
         git pull
         # 等价于下面两条指令
         git fetch
         git merge origin/master
         ```
   
   33. ## 跟踪远程仓库的分支
   
       + ### 添加跟踪远程分支的本地分支
   
         #### 包含 `remotes/origin` 开头的分支是来自原始仓库的分支。注意你没有叫 greet 的分支，但它知道原始仓库有 greet 分支
   
         ```shell
         git branch --track greet origin/greet
         Branch 'greet' set up to track remote branch 'greet' from 'origin'.
         
         git branch -a
           greet
         * master
           remotes/origin/HEAD -> origin/master
           remotes/origin/greet
           remotes/origin/master
           
         git hist --max-count=2
         * 6082ec5 2020-05-24 | 修改了clone仓库的远程仓库 (HEAD -> master, origin/master, origin/HEAD) [undermoonoldman]
         * 5b09fd4 2020-05-24 | greet分支第二第三次修改 (origin/greet, greet) [undermoonoldman]
         ```
   
         #### 现在可以在分支列表和日志中看到 greet 分支了
   
   34. ## 裸仓库
   
       + ### 创建裸仓库
   
         #### 裸仓库（没有工作目录）通常用于共享
   
         ```shell
         cd ..
         
         git clone --bare learn_git learn_git.git
         Cloning into bare repository 'learn_git.git'...
         done.
         
         ls learn_git.git
         HEAD        config      description hooks       info        objects     packed-refs refs
         ```
   
         #### 结尾带 `.git` 的仓库习惯约定为裸仓库。我们可以看到在 learn_git.git 仓库中没有工作目录
   
       + ### 将裸仓库作为远程仓库添加到原始仓库中
   
         ```shell
         # 切换到原始仓库所在的目录
         cd ../learn_git
         git remote add shared ../learn_git.git
         
         # 重新查看远程仓库，已经添加成功了
         git remote
         origin
         shared
         ```
   
   35. ## 推送更新到共享仓库与从共享仓库拉取更新
   
       + ### 推送更改到共享仓库
   
         ```shell
         # 本地更新提交
         echo "共享仓库推送更新测试" >> LearnGit.txt
         git add LearnGit.txt
         git commit -m "更新推送到共享仓库"
         
         # 本地更新推送到共享远程仓库
         git push shared master
         Enumerating objects: 5, done.
         Counting objects: 100% (5/5), done.
         Delta compression using up to 4 threads
         Compressing objects: 100% (2/2), done.
         Writing objects: 100% (3/3), 342 bytes | 342.00 KiB/s, done.
         Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
         To ../learn_git.git
            6082ec5..343e7e8  master -> master
         ```
   
         #### 我们必须明确地指定接收推送的分支名称 master
   
       + ### 从共享的远程仓库中拉取更改
   
         #### 进入克隆仓库，且让我们拉取刚才推送到共享仓库的更改
   
         ```shell
         # 进入克隆仓库目录
         cd ../cloned_learn_git
         # 添加远程共享仓库
         git remote add shared ../learn_git.git
         
         # 跟踪更新的主分支
         git branch --track shared master
         Branch 'shared' set up to track local branch 'master'.
         
         # 拉取并合并远程的更新
         git pull shared master
         remote: Enumerating objects: 5, done.
         remote: Counting objects: 100% (5/5), done.
         remote: Compressing objects: 100% (2/2), done.
         remote: Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
         Unpacking objects: 100% (3/3), 322 bytes | 161.00 KiB/s, done.
         From ../learn_git
          * branch            master     -> FETCH_HEAD
          * [new branch]      master     -> shared/master
         Updating 6082ec5..343e7e8
         Fast-forward
          LearnGit.txt | 1 +
          1 file changed, 1 insertion(+)
         ```

