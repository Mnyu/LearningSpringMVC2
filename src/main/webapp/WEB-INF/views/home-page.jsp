<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <style type="text/css">
        .error {
            color: red;
            position: fixed;
            text-align: left;
            margin-left: 30px;
        }
    </style>
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
                <form:input id="yn" path="userName"/>
                <form:errors path="userName" cssClass="error"/>
            </p>
            <p>
                <label for="fn">Friend's Name : </label>
                <form:input id="fn" path="friendName"/>
                <form:errors path="friendName" cssClass="error"/>
            </p>
            <p>
                <form:checkbox path="termsAndConditionsAccepted" id="check"/>
                <label>I am agreeing that this is for fun!</label>
                <form:errors path="termsAndConditionsAccepted" cssClass="error"/>
            </p>

            <input type="submit" value="Calculate">
        </div>
    </form:form>
</body>
</html>
