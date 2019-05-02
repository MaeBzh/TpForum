<%--
  Created by IntelliJ IDEA.
  User: Maelenn
  Date: 02/05/2019
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<body>
<jsp:include page="header.jsp"/>

<div class="row">
    <div class="card col-md-6 mt-5 mx-auto">
        <div class="card-header h4 mb-4">Afficher message</div>
        <div class="card-body">
            <p>Date : ${message.date}</p>
            <p>Message : ${message.content}</p>
            <p>Auteur : ${message.author}</p>
            <p>Thread : ${message.thread}</p>
            <p>id : ${message.id}</p>

        </div>
    </div>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>
