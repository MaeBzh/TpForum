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
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="../inc/style.css" />
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="row">
    <div class="card col-md-6 my-5 mx-auto p-0">
        <div class="card-header bg-info mb-4 text-white"><h2>Inscription</h2></div>
        <div class="card-body">
            <form class="text-center border border-light p-5 " action="signin" method="post">

                <label for="firstname">Prénom</label>
                <input type="text" id="firstname" class="form-control mb-4" placeholder="Prénom" name="firstname" required>

                <label for="lastname">Nom</label>
                <input type="text" id="lastname" class="form-control mb-4" placeholder="Nom" name="lastname" required>

                <label for="pseudo">Pseudo</label>
                <input type="text" id="pseudo" class="form-control mb-4" placeholder="Pseudo" name="pseudo" required>

                <label for="email">E-mail</label>
                <input type="email" id="email" class="form-control mb-4" placeholder="E-mail" name="email" required>

                <label for="password">Mot de passe</label>
                <input type="password" id="password" class="form-control mb-4" placeholder="Mot de passe" name="password" required>

                <label for="avatar">Avatar</label>
                <input type="button" id="avatar" class="form-control mb-4" name="avatar">

                <button class="btn btn-info btn-block my-4" type="submit">Valider</button>

            </form>
            <!-- Default form login -->
        </div>
    </div>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>
