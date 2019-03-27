<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Exposition Calendar Homepage</title>
</head>

<body>
<jsp:include page="util/header.jsp"/>
<div class="col-lg-3">
<h1>Home</h1>
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/app?controller=addSchoolExam"
           class="list-group-item">Add School Exam</a>
        <a href="${pageContext.request.contextPath}/app?controller=showApplications"
           class="list-group-item">My Applications</a>
        <a href="${pageContext.request.contextPath}/app?controller=addApplication"
           class="list-group-item">Chose Specialty</a>
        <%--<a href="${pageContext.request.contextPath}/app?controller=cart&currentPage=1" class="list-group-item">Cart</a>--%>
        <%--<a href="${pageContext.request.contextPath}/app?controller=logout" class="list-group-item">Log out</a>--%>

        <%--<c:choose>--%>
            <%--<c:when test="${sessionScope.role == 'ADMIN'}">--%>
                <%--<a href="${pageContext.request.contextPath}/app?controller=admin" class="list-group-item">Admin</a>--%>
            <%--</c:when>--%>
        <%--</c:choose>--%>

    </div>
</div>
</body>

</html>
