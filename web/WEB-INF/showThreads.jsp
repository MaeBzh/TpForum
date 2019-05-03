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
<div class="row">
    <div class="card col-md-6 my-5 mx-auto p-0">
        <div class="card-header bg-info mb-4 text-white"><h2>Discussions</h2></div>
        <div class="card-body">
            <c:choose>
                <c:when test="${not empty listThread}">
                    <table class="table">
                        <c:forEach items="${listThread}" var="thread">
                            <tr>
                                <td class="row">
                                    <a class="col-md-8 text-secondary" href="thread/?catId=${catId}&thrId=${thread.id}">${thread.title}</a>
                                    <p class="col-md-4 text-info">Auteur : ${thread.author.pseudo}</p>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>
                <c:otherwise><c:out value="Aucun sujet n'a été trouvé"/></c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</body>
</html>
