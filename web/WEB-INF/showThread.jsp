<%--
  Created by IntelliJ IDEA.
  User: Aurion
  Date: 02/05/2019
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/head.jsp" %>
<html>
<body>
<table>
    <c:forEach items="${listMessage}" var="message">
        <tr>
            <td>
                <p>Subject : ${thread.title}</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>${message.content}</p>
            </td>
        </tr>
        <tr>
            <td><p>Auteur : ${thread.author}</p><p>Posté le : ${message.date}</p></td>
        </tr>
    </c:forEach>
</table>
<c:out value="Mon catId est : ${catId}"></c:out><br />
<c:out value="Mon thrId est : ${thrId}"></c:out>
</body>
</html>
