<%--
  Created by IntelliJ IDEA.
  User: Xueyong
  Date: 2018/6/1
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <h2>用户登录界面</h2>
  <form method="post" action="loginServlet">
    用户名：<input type="text" name="username"/>
    密码：<input type="password" name="password"/>
    <input type="submit" value="登录"/>
  </form>
  </body>
</html>
