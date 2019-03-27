<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png"/>
<head>
    <title>APPLICATIONS</title>
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
        <c:forEach items="${requestScope.applications}" var="appl" varStatus="loop">
            <tr>
                    <%--<th scope="row"><c:out value="${loop.index + 1}"/></th>--%>
                <td><c:out value="${spec.specialtyName}"/></td>

                <td>
                    <a class="btn btn-primary" role="button"
                       href="${pageContext.request.contextPath}/app?controller=deleteApplication&applicationId=${spec.id}">
                        <c:out value="Delete"/>
                    </a>
                </td>


            </tr>
        </c:forEach>
        </tbody>
    </table>


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

<nav aria-label="Navigation for countries">
    <ul class="pagination">
        <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="/app?controller=showExpo&currentPage=${currentPage-1}">Previous</a>
                    <%--recordsPerPage=${recordsPerPage}&--%>
            </li>
        </c:if>

        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <li class="page-item active"><a class="page-link">
                            ${i} <span class="sr-only">(current)</span></a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="/app?controller=showExpo&currentPage=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="/app?controller=showExpo&currentPage=${currentPage+1}">Next</a>
            </li>
        </c:if>
    </ul>
</nav>

</body>


</html>