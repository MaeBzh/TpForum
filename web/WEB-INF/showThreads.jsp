<%--
  Created by IntelliJ IDEA.
  User: Aurion
  Date: 02/05/2019
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/head.jsp" %>
<html>
<body>
showThreads
<table>
    <c:forEach items="${listThreads}" var="thread">
        <tbody><a>${thread['title']}</a></tbody>
    </c:forEach>
</table>
</body>
</html>
