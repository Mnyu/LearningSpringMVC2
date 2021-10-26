<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
    <h2 align="center">Login</h2>
    <c:if test="${param.error != null }">
        <i style="color: red">Invalid username or password!</i>
    </c:if>
    <br/><br/>
    <form:form action="process-login" method="POST">
        Username : <input type="text" name="username"><br/><br/>
        Password : <input type="password" name="password"><br/><br/>
        <input type="submit" value="Login">
    </form:form>
    <form:form action="signup" method="GET">
        <input type="submit" value="Register">
    </form:form>
</body>
</html>
