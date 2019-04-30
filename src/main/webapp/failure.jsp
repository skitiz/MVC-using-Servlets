<%--
  Created by IntelliJ IDEA.
  User: kshit
  Date: 4/25/2019
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Failure</title>
</head>
<body>
<h2>Invalid Credentials</h2>
<form action="authenticate" method="post">
    Username: <input type="text" name="uname">
    Password: <input type="password" name="pwd">
    <input type="submit">
</form>
<a href="register.jsp">Register</a>
</body>
</html>
