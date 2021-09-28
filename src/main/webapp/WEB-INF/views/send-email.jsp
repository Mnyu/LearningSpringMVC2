<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send Email</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
    <h2 align="center">Hi ${userDTO.userName}!</h2>
    <h2 align="center">Send Result to your Email</h2>
    <form:form action="process-email"  method="GET" modelAttribute="emailDTO">
        <div align="center">
            <p>
                <label>Enter your Email : </label>
                <form:input path="userEmail"/>
            </p>
        </div>
        <div align="center">
            <p><input type="submit" value="Send"></p>
        </div>
    </form:form>
</body>
</html>
