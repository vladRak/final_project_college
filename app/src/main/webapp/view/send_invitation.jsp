<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png"/>
<head>
    <title>SEND INVITATION</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="m-3">
<jsp:include page="util/header.jsp"/>

<div class="row col-md-6">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Specialty</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.specialties}" var="spec" varStatus="loop">
            <tr>
                    <%--<th scope="row"><c:out value="${loop.index + 1}"/></th>--%>
                <td><c:out value="${spec.specialtyName}"/></td>

                <td>
                    <a class="btn btn-primary" role="button"
                       href="${pageContext.request.contextPath}/app?controller=sendInvitation&specialtyId=${spec.id}">
                        <c:out value="Send"/>
                    </a>
                </td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>


</html>