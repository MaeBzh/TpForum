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
        <div class="card-header h4 mb-4">Connexion</div>
        <div class="card-body">
            <form class="text-center border border-light p-5" action="login" method="post">

                <input type="text" id="pseudo" class="form-control mb-4" placeholder="Pseudo" name="pseudo">

                <input type="password" id="password" class="form-control mb-4" placeholder="Mot de passe" name="password">

                <div class="d-flex justify-content-around">
                    <div>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
                            <label class="custom-control-label" for="defaultLoginFormRemember">Se souvenir de moi</label>
                        </div>
                    </div>
                    <div>
                        <a href="">Mot de passe oublié ?</a>
                    </div>
                </div>

                <!-- Sign in button -->
                <button class="btn btn-info btn-block my-4" type="submit">Connexion</button>

                <!-- Register -->
                <p>Pas encore de compte ?
                    <a href="">Inscription</a>
                </p>

            </form>
            <!-- Default form login -->
        </div>
    </div>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>
