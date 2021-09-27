<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
    <h2 align="center">Registration Successful!!!</h2>
    <h3> The details are :</h3><br/>
    Name : ${userRegDTO.name}<br/>
    Username : ${userRegDTO.userName}<br/>
    Password : ${userRegDTO.password}<br/>
    Country : ${userRegDTO.country}<br/>
    Hobbies :
        <c:forEach var="temp" items="${userRegDTO.hobbies}">
            ${temp}
        </c:forEach>
    <br/>
    Gender : ${userRegDTO.gender}<br/>
    Age : ${userRegDTO.age}<br/>
    Email  : ${userRegDTO.communicationDTO.email}<br/>
    Phone  : ${userRegDTO.communicationDTO.phone}<br/>
</body>
</html>
