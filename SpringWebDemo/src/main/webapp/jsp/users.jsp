<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <tr>
        <th>Names from JSP</th>
    </tr>
    <c:forEach items="${namesFromServer}" var="name">
        <tr>
            <td>${name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
