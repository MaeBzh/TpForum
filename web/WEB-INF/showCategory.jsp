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
<jsp:include page="header.jsp"/>
<body>
<div class="row">
    <div class="card col-md-6 my-5 mx-auto p-0">
        <div class="card-header bg-info mb-4 text-white"><h2>Catégories</h2></div>
        <div class="card-body">
            <table class="table">
                <c:forEach items="${listCategory}" var="category">
                    <tr>
                        <td class="row">
                            <a class="col-md-10 text-secondary" href="category/?catId=${category.id}">${category.title}</a>
                            <p>${category.nbThreads} discussions</p>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
</div>

</body>
</html>
<%@include file="footer.jsp" %>