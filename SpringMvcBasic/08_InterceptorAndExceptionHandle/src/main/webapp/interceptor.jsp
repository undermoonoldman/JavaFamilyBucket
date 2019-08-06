<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arthur
  Date: 2019-07-01
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拦截器测试页面</title>
</head>
<body>
<h1>
    拦截器测试页面
</h1>
<br>

<p>
    <a href="user/testInterceptor_01">测试拦截器方法的执行顺序</a>
</p>
<br>

<p>
    <a href="user/testInterceptor_02">测试拦截器前置拦截不放行</a>
</p>
<br>

<p>
    <a href="user/testInterceptor_03">测试拦截器后置拦截</a>
</p>
<br>

<p>
    <a href="user/testInterceptorChain">测试拦截器执行链</a>
</p>

</body>
</html>