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
    <c:forEach items="${listMessages}" var="message">
        <tr>
            <td>
                <p>Subject : ${titleThr}</p>
            </td>
        </tr>
        <tr>
            <td>
                <p>${message.content}</p>
            </td>
        </tr>
        <tr>
            <td><p>Auteur : ${message.author.pseudo}</p></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
