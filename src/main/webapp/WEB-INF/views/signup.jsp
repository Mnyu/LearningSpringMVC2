<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
    <h2 align="center">Register here</h2>

    <form:form action="process-signup" method="POST" modelAttribute="signupDTO">
        <div align="center">
            <p>
                <label>Username : </label>
                <form:input path="username"/>
            </p>
            <p>
                <label>Password : </label>
                <form:password path="password"/>
            </p>
        </div>
        <div align="center">
            <p>
                <input type="submit" value="Register">
            </p>
        </div>
    </form:form>
</body>
</html>
