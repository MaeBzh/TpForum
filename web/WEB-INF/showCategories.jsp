<%--
  Created by IntelliJ IDEA.
  User: Aurion
  Date: 02/05/2019
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/head.jsp" %>
<html>
<body>
<table>
    <c:forEach items="${listCategories}" var="categorie">
        <tbody><a>${categorie}</a></tbody>
    </c:forEach>
</table>
</body>
</html>
<%@include file="footer.jsp" %>