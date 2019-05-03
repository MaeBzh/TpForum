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
<jsp:include page="header.jsp"/>
<div class="row">
    <div class="card col-md-6 my-5 mx-auto p-0">
        <div class="card-header bg-info mb-4 text-white"><h2>Sujet : ${titleThr}</h2></div>
        <div class="card-body">
            <table class="table">
                <c:forEach items="${listMessages}" var="message">
                    <tr>
                        <td class="d-block">
                            <p>${message.content}</p>
                        <td>
                        <td class="d-block">
                            <p class="text-info">Auteur : ${message.author.pseudo}</p>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="text-center">
                <a class="btn btn-info" href="message/?thrId=${thread.id}">Répondre</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
