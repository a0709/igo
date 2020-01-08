<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/7/007
  Time: 上午 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="Update" method="post">
    用户名：<input type="text" name="username"><br>
    密    码  ：<input type="text" name="password"><br>
    年    龄  ：<input type="text" name="age" value="${user.age}"><br/>
    <input type="hidden" name="id" value="${user.id}"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
