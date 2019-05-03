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
<jsp:include page="header.jsp"/>
<body>
<table>
    <c:forEach items="${listCategory}" var="category">
        <tr>
            <td>
                <a href="category/?catId=${category.id}">${category.title}</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
<%@include file="footer.jsp" %>