<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
<%--    <form action="processHomepage" method="get">--%>
<%--        <div align="center">--%>
<%--            <p>--%>
<%--                <label for="yn">Your Name : </label>--%>
<%--                <input type="text" id="yn" name="userName"/>--%>
<%--            </p>--%>
<%--            <p>--%>
<%--                <label for="fn">Friend's Name : </label>--%>
<%--                <input type="text" id="fn" name="friendName"/>--%>
<%--            </p>--%>
<%--            <input type="submit" value="calculate">--%>
<%--        </div>--%>
<%--    </form>--%>

    <!-- Instead of plain html tags we will use Spring MVC tags to achieve 2-way data binding -->

    <form:form action="processHomepage" method="get" modelAttribute="userDTO">
        <div align="center">
            <p>
                <label for="yn">Your Name : </label>
                <form:input type="text" id="yn" path="userName"/>
            </p>
            <p>
                <label for="fn">Friend's Name : </label>
                <form:input type="text" id="fn" path="friendName"/>
            </p>
            <input type="submit" value="calculate">
        </div>
    </form:form>
</body>
</html>
