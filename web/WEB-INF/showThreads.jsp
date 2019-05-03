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
<c:choose>
    <c:when test="${not empty listThread}">
        <table>
            <c:forEach items="${listThread}" var="thread">
                <tr>
                    <td>
                        <a href="thread/?catId=${catId}&thrId=${thread.id}">${thread.title}</a>
                    </td>
                </tr>
                <tr>
                    <td><p>Auteur : ${thread.author.pseudo}</p></td>
                    <td><c:if test="${thread.isSolved}" ><c:out value="Sujet résolu" /></c:if></td>
<%--                    <td><c:if test="${thread.isSolved == false}"><c:out value="Sujet en cours" /></c:if></td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise><c:out value="Aucun sujet n'a été trouvé"/></c:otherwise>
</c:choose>
</body>
</html>
