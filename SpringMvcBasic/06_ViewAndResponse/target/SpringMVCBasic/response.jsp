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
    <title>响应测试页面</title>
    <script src="js/jquery.min.js"></script>

    <script>
        // 页面加载，绑定单击事件
        $(function(){
            $("#btn").click(function(){
                alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url:"user/testResponseBody",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"name":"LiMing","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.name);
                        alert(data.password);
                        alert(data.age);
                    }
                });

            });
        });

    </script>
</head>
    <body>
        <h3>
            响应测试页面
        </h3>
        <p>
            <a href="user/testString">TestString</a>
        </p>
        <br>
        <p>
            <a href="user/testVoidForward">TestVoidForward</a>
        </p>
        <br>
        <p>
            <a href="user/testVoidRedirect">TestVoidRedirect</a>
        </p>
        <br>
        <p>
            <a href="user/testVoidWrite">TestVoidWrite</a>
        </p>
        <br>
        <p>
            <a href="user/testModelAndView">TestModelAndView</a>
        </p>
        <br>
        <p>
            <a href="user/testForward">TestForward</a>
        </p>
        <br>
        <p>
            <a href="user/testRedirect">TestRedirect</a>
        </p>
        <br>

        <button id="btn">TestResponseBody</button>
    </body>
</html>