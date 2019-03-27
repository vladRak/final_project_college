<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png"/>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>
</head>

<body class="bg-dark">

<form method="post" action="${pageContext.request.contextPath}/app">
    <div class="form-group">
        <c:out value="${message}"/>
        <div class="form-label-group">
            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address"
                   required="required" autofocus="autofocus">
            <label for="inputEmail">Email address</label>
        </div>
    </div>
    <div class="form-group">
        <div class="form-label-group">
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password"
                   required="required">
            <label for="inputPassword">Password</label>
        </div>
    </div>
    <div class="form-group">
    </div>
    <button type="submit" name="controller" value="login" class="btn btn-primary btn-block">Log in</button>
</form>
<div class="text-center">
    <a class="d-block small mt-3" href="${pageContext.request.contextPath}/app?controller=register">Register an
        Account</a>
</div>

</body>

</html>
