<header class="row bg-secondary text-white">
    <h1 id="header_title" class="col-md-6">TP Forum</h1>
    <div class="col-md-6">
        <c:choose>
            <c:when test="${empty sessionScope.connectedUser}">
                <a class="btn btn-info col-md-5 m-2" href="login">Connexion</a>
                <a class="btn btn-info col-md-5 m-2" href="signin">Inscription</a>
            </c:when>
            <c:otherwise>
                <p class="col-md-5 m-2 d-inline-block">Bonjour ${sessionScope.connectedUser.pseudo}</p>
                <form class="col-md-5 m-2 d-inline-block" action="logout" method="post">
                    <input class="btn btn-info" type="submit" name="logout" value="Deconnexion"/>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</header>
