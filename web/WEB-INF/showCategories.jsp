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
    <p>Utilisateur connecté : ${sessionScope.connectedUser.id}</p>

    <c:forEach items="${listCategories}" var="categorie">
        <tr>
            <th>
                <a href="categorie/${categorie}">${categorie}</a>
            </th>
        </tr>
    </c:forEach>

</table>
<%--TODO : Transformer les <p> de la table en lien pour qu'elles pointent vers showThread et qu'elles affichent les messages--%>
</body>
</html>
<%@include file="footer.jsp" %>