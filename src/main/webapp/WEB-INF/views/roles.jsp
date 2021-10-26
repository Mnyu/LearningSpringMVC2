<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles Testing</title>
</head>
<body>
    <br/><br/>
    <h2>Hi ${username}</h2><br/>
    <h3>Roles : ${roles}</h3>
    <br/><br/>
    <sec:authorize access='hasAuthority("ADMIN")'>
    <a href="/LearningSpringMVC2_war/admin">Show Admin Dashboard</a><br/><br/>
    </sec:authorize>
    <sec:authorize access='hasAuthority("USER")'>
    <a href="/LearningSpringMVC2_war/user">Show User Dashboard</a><br/><br/>
    </sec:authorize>
</body>
</html>
