<%--
  Created by IntelliJ IDEA.
  User: kshit
  Date: 4/28/2019
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<h2>You have been successfully logged out!</h2>
<%
    session.invalidate();
%>
</body>
</html>
