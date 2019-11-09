<%--
  Created by IntelliJ IDEA.
  User: Elfa
  Date: 10/29/2019
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="../getConnection">
    <input name="type" type="submit" value="MYSQL"><br>
    <input name="type" type="submit" value="DERBY">
</form>

<c:if test="${not empty con}">
    <hr>
    <c:out value="${con}"/>
</c:if>
<c:if test="${ empty con}">
    <hr>
    <p>Hello</p>
</c:if>
</body>
</html>
