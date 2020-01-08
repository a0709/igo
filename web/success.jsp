<%-- Created by IntelliJ IDEA. --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆成功</title>
  </head>
  <body>
  <h2>欢迎进入!</h2>
  <table border="1">
    <tr>
    <tr>
      <th>编号</th>
      <th>用户名</th>
      <th>密码</th>
      <th>年龄</th>
      <th>操作</th>
    </tr>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="s">
      <tr>
        <td>${s.count}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.age}</td>
        <td><a href="FindOne?id=${user.id}">修改</a>
          ||
          <a href="delete?id=${user.id}">删除</a>
        </td>

      </tr>

    </c:forEach>
    <a href="add.jsp">新增</a>
  </table>
  </body>
</html>