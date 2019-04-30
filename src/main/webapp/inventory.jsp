<%--
  Created by IntelliJ IDEA.
  User: kshit
  Date: 4/25/2019
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
    <title>Inventory</title>
</head>
<body>
<table>
    <caption>Inventory</caption>
    <tr>
        <th>Product Name</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="value" items="${sessionScope.map}">
        <tr>
        <td><c:out value="${value.key}" /></td>
        <td><c:out value="${value.value}"/></td>
        <td><a href="updatedb.jsp" <c:set var="itemKey" value="${value.key}" scope="session"/>>Update</a> </td>
        </tr>
    </c:forEach>
</table>

<a href="logout.jsp">Logout</a>
</body>
</html>
