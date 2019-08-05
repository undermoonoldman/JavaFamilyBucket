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
    <title>文件上传测试页面</title>
</head>
    <body>
        <h1>
            文件上传测试页面
        </h1>
        <br>

        <h3>传统方式文件上传</h3>

        <form action="/user/fileupload_01" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="upload" /><br/>
            <input type="submit" value="上传" />
        </form>
        <br>

        <h3>SpringMvc文件上传</h3>

        <form action="/user/fileupload_02" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="upload" /><br/>
            <input type="submit" value="上传" />
        </form>
    </body>
</html>
