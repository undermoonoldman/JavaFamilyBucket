<%--
  Created by IntelliJ IDEA.
  User: arthur
  Date: 2019-07-01
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
<h3>
    常用注解
</h3>
<p>
    <a href="anno/testRequestParam?name=xiaoming">RequestParam</a>
</p>
<br>
<p>
<form action="/anno/testRequestBody" method="post">
    账户名:<input type="text" name="username" /> <br/>
    年龄:<input type="text" name="age" /> <br/>
    <input type="submit" value="提交" /> <br/>
</form>
</p>
<br>
<p>
    <a href="anno/testPathVariable/9527">PathVariable</a>
</p>
<br>
<p>
    <a href="anno/testRequestHeader">RequestHeader</a>
</p>
<br>
<p>
    <a href="anno/testCookieValue">CookieValue</a>
</p>
<br>
<form action="/anno/testModelAttribute_01" method="post">
    账户名:<input type="text" name="name" /> <br/>
    年龄:<input type="text" name="age" /> <br/>
    <input type="submit" value="提交" /> <br/>
</form>
<br>
<form action="/anno/testModelAttribute_02" method="post">
    账户名:<input type="text" name="name" /> <br/>
    年龄:<input type="text" name="age" /> <br/>
    <input type="submit" value="提交" /> <br/>
</form>
<br>
<p>
    <a href="anno/testSessionAttributes">SessionAttributes</a>
</p>
<br>
<p>
    <a href="anno/getSessionAttributes">GetSessionAttributes</a>
</p>
<br>
<p>
    <a href="anno/delSessionAttributes">DelSessionAttributes</a>
</p>
</body>
</html>