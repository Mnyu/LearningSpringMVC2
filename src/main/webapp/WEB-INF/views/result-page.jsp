<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
    <h2>The Frenemy Calculator predicts : </h2>
    <p>${userDTO.userName} and ${userDTO.friendName} are </p>
    <p>${userDTO.relation}</p>
    <br/><br/><br/>
    <a href="/LearningSpringMVC2_war/send-email">Send Result to your mail</a>
</body>
</html>
