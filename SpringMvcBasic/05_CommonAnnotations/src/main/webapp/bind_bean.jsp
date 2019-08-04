<%--
  Created by IntelliJ IDEA.
  User: arthur
  Date: 2019-07-02
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数bean类型绑定</title>
</head>
<body>
    <form action="/param/bindbean" method="post">
        账户名:<input type="text" name="username" /> <br/>
        密码:<input type="password" name="password" /> <br/>
        金额:<input type="text" name="money" /> <br/>
        <input type="submit" value="提交" /> <br/>
        用户名:<input type="text" name="user.name" /> <br/>
        年龄:<input type="text" name="user.age" /> <br/>
        <input type="submit" value="提交" /> <br/>
    </form>
</body>
</html>
