<%--
  Created by IntelliJ IDEA.
  User: Maelenn
  Date: 02/05/2019
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="head.jsp"/>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>${title}</title>--%>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">--%>
<%--    <link type="text/css" rel="stylesheet" href="../inc/style.css" />--%>
<%--</head>--%>
<body>
<jsp:include page="header.jsp"/>
<div class="row">
    <div class="card col-md-6 my-5 mx-auto p-0">
        <div class="card-header bg-info mb-4 text-white"><h2>Connexion</h2></div>
        <div class="card-body">
            <form class="text-center border border-light p-5" action="login" method="post">

                <input type="text" id="pseudo" class="form-control mb-4" placeholder="Pseudo" name="pseudo" value="dev" required>

                <input type="password" id="password" class="form-control mb-4" placeholder="Mot de passe" value="azerty" name="password" required>

                <div class="d-flex justify-content-around">
                    <a href="forgot_password">Mot de passe oublié ?</a>
                </div>

                <button class="btn btn-info btn-block my-4" type="submit">Connexion</button>

                <p>Pas encore de compte ?
                    <a href="signin" class="text-info">Inscription</a>
                </p>

            </form>
            <!-- Default form login -->
        </div>
    </div>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>
