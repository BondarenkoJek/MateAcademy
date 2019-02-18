<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>add</title>
    <%--<link href="css/login.css" rel="stylesheet"/>--%>
    <%--<script src="/resources/js/jquery-3.3.1.js"></script>--%>
</head>
<body>
<div>
    <form id="loginForm" class="form" action="/login", method="post">
        <h2>Authorization</h2>
        <label for="login">Login</label>
        <input id="login" name="login" type="text"/>

        <label for="password">Password</label>
        <input id="password" name="password" type="password"/>

        <%--<c:if test="${error}" >--%>
            <%--<div class="alert-danger">login or password entered incorrectly</div>--%>

        <%--</c:if>--%>

        <input value="Login" type="submit">
        <div class="div_a"><a href="/registration">registration</a></div>
    </form>
</div>
<%--<script src="/resources/js/login.js"></script>--%>
</body>
</html>
