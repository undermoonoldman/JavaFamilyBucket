<%--
  Created by IntelliJ IDEA.
  User: arthur
  Date: 2019-07-02
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数集合类型绑定</title>
</head>
<body>
    <form action="/param/bindcollection" method="post">
        品牌名称:<input type="text" name="brand" /> <br/>
        最高速度:<input type="password" name="speed" /> <br/>

        用户名:<input type="text" name="userList[0].name" /> <br/>
        年龄:<input type="text" name="userList[0].age" /> <br/>

        用户名:<input type="text" name="userList[1].name" /> <br/>
        年龄:<input type="text" name="userList[1].age" /> <br/>

        用户名:<input type="text" name="userMap['one'].name" /> <br/>
        年龄:<input type="text" name="userMap['one'].age" /> <br/>

        用户名:<input type="text" name="userMap['two'].name" /> <br/>
        年龄:<input type="text" name="userMap['two'].age" /> <br/>
        <input type="submit" value="提交" /> <br/>
    </form>
</body>
</html>
