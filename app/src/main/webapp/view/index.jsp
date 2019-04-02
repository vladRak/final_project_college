<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page session="false"%>--%>
<html lang="en">
<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png"/>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Exposition Calendar</title>
</head>
<body id="page-top">
<ul>
    <c:choose>
        <c:when test="${sessionScope.role == 'ADMIN' || sessionScope.role == 'APPLICANT'}">
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger"
                   href="${pageContext.request.contextPath}/app?controller=home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger"
                   href="${pageContext.request.contextPath}/app?controller=logout">Log out</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger"
                   href="${pageContext.request.contextPath}/app?controller=login">Log in</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger"
                   href="${pageContext.request.contextPath}/app?controller=register">Sign up</a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>
</body>
</html>
