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
<table>
    <c:forEach items="${listThread}" var="thread">
        <tr>
            <td>
                <a href="threads/${thread.id}">${thread.title}</a>
            </td>
        </tr>
        <tr>
            <td><p>Auteur : ${thread.author}</p></td>
        </tr>
    </c:forEach>
</table>
<c:out value="Mon id est : ${id}"></c:out>
</body>
</html>
