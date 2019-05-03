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
        <div class="card-header h4 mb-4">Nouveau message</div>
        <div class="card-body">
        <form class="col-6 text-center border border-light p-5" method="post" action="createthread/new">

            <label for="title"></label>
            <input type="text" name="title" id="title" value="">
            <label for="messageContent" class="mt-2">Message</label>
            <textarea id="messageContent" class="form-control mb-4" name="content"></textarea>
            <input type="hidden" name="catId" value="${catId}">

            <button class="btn btn-info btn-block my-4 cyan-50" type="submit">Envoyer</button>

        </form>
        </div>
    </div>
</div>

</body>
<jsp:include page="footer.jsp"/>
</html>
