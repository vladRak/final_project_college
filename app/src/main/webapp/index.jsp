<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ page session="false"%>--%>
<jsp:forward page="/view/index.jsp"/>
<%--<%@ page session="true"%>--%>
<%--<html lang="en">--%>
<%--<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/favicon.png"/>--%>

<%--<head>--%>

    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>Exposition Calendar</title>--%>

    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
    <%--<link href="css/scrolling-nav.css" rel="stylesheet">--%>

<%--</head>--%>

<%--<body id="page-top">--%>

<%--<!-- Navigation -->--%>
<%--<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">--%>
    <%--<div class="container">--%>
        <%--<a class="navbar-brand js-scroll-trigger" href="#page-top">Exposition Calendar</a>--%>
        <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"--%>
                <%--aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">--%>
            <%--<span class="navbar-toggler-icon"></span>--%>
        <%--</button>--%>
        <%--<div class="collapse navbar-collapse" id="navbarResponsive">--%>
            <%--<ul class="navbar-nav ml-auto">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${sessionScope.role == 'USER' || sessionScope.role == 'ADMIN'}">--%>
                        <%--<li class="nav-item">--%>
                            <%--<a class="nav-link js-scroll-trigger"--%>
                               <%--href="${pageContext.request.contextPath}/app?controller=home">Home</a>--%>
                        <%--</li>--%>
                        <%--<li class="nav-item">--%>
                            <%--<a class="nav-link js-scroll-trigger"--%>
                               <%--href="${pageContext.request.contextPath}/app?controller=logout">Log out</a>--%>
                        <%--</li>--%>
                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>
                        <%--<li class="nav-item">--%>
                            <%--<a class="nav-link js-scroll-trigger"--%>
                               <%--href="${pageContext.request.contextPath}/app?controller=loginPage">Log in</a>--%>
                        <%--</li>--%>
                        <%--<li class="nav-item">--%>
                            <%--<a class="nav-link js-scroll-trigger"--%>
                               <%--href="${pageContext.request.contextPath}/app?controller=registrationPage">Sign up</a>--%>
                        <%--</li>--%>
                    <%--</c:otherwise>--%>
                <%--</c:choose>--%>
            <%--</ul>--%>


            <%--&lt;%&ndash;<ul class="navbar-nav ml-auto">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/app?controller=loginPage">Log in</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/app?controller=registrationPage">Sign up</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li class="nav-item">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<a class="nav-link js-scroll-trigger" href="#contact">Contact</a>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</ul>&ndash;%&gt;--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>

<%--<header class="bg-primary text-white">--%>
    <%--<div class="container text-center">--%>
        <%--<h1>Welcome to Exposition Calendar</h1>--%>
        <%--<p class="lead">A landing page template freshly redesigned for Bootstrap 4</p>--%>
    <%--</div>--%>
<%--</header>--%>

<%--<section id="about">--%>
    <%--<div class="container">--%>
        <%--<div class="row">--%>
            <%--<div class="col-lg-8 mx-auto">--%>
                <%--<h2>About this page</h2>--%>
                <%--<p class="lead">This is a great place to talk about your webpage. This template is purposefully unstyled--%>
                    <%--so you can use it as a boilerplate or starting point for you own landing page designs! This template--%>
                    <%--features:</p>--%>
                <%--<ul>--%>
                    <%--<li>Clickable nav links that smooth scroll to page sections</li>--%>
                    <%--<li>Responsive behavior when clicking nav links perfect for a one page website</li>--%>
                    <%--<li>Bootstrap's scrollspy feature which highlights which section of the page you're on in the--%>
                        <%--navbar--%>
                    <%--</li>--%>
                    <%--<li>Minimal custom CSS so you are free to explore your own unique design options</li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</section>--%>

<%--&lt;%&ndash;<section id="services" class="bg-light">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="container">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-lg-8 mx-auto">&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Services we offer</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut optio velit inventore, expedita quo laboriosam possimus ea consequatur vitae, doloribus consequuntur ex. Nemo assumenda laborum vel, labore ut velit dignissimos.</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</section>&ndash;%&gt;--%>

<%--&lt;%&ndash;<section id="contact">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="container">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="row">&ndash;%&gt;--%>
<%--&lt;%&ndash;<div class="col-lg-8 mx-auto">&ndash;%&gt;--%>
<%--&lt;%&ndash;<h2>Contact us</h2>&ndash;%&gt;--%>
<%--&lt;%&ndash;<p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero odio fugiat voluptatem dolor, provident officiis, id iusto! Obcaecati incidunt, qui nihil beatae magnam et repudiandae ipsa exercitationem, in, quo totam.</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</section>&ndash;%&gt;--%>

<%--<!-- Footer -->--%>
<%--<footer class="py-5 bg-dark">--%>
    <%--<div class="container">--%>
        <%--<p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>--%>
    <%--</div>--%>
    <%--<!-- /.container -->--%>
<%--</footer>--%>

<%--<!-- Bootstrap core JavaScript -->--%>
<%--<script src="vendor/jquery/jquery.min.js"></script>--%>
<%--<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>--%>

<%--<!-- Plugin JavaScript -->--%>
<%--<script src="vendor/jquery-easing/jquery.easing.min.js"></script>--%>

<%--<!-- Custom JavaScript for this theme -->--%>
<%--<script src="js/scrolling-nav.js"></script>--%>

<%--</body>--%>

<%--</html>--%>
