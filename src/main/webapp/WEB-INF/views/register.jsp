<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1 align="center">Frenemy Calculator</h1>
    <hr/>
    <h2 align="center">Please register here</h2>

    <form:form action="registration-success" method="post" modelAttribute="userRegDTO">
        <div align="center">
            <p>
                <label>Name : </label>
                <form:input path="name"/>
            </p>
            <p>
                <label>Username : </label>
                <form:input path="userName"/>
            </p>
            <p>
                <label>Password : </label>
                <form:password path="password"/>
            </p>
            <p>
                <label>Country : </label>
                <form:select path="country">
                    <form:option value="ind" label="India"/>
                    <form:option value="usa" label="USA"/>
                    <form:option value="uk" label="UK"/>
                    <form:option value="ger" label="Germany"/>
                </form:select>
            </p>
            <p>
                <label>Hobbies : </label>
                Cricket <form:checkbox path="hobbies" value="cricket"/>
                Reading <form:checkbox path="hobbies" value="reading"/>
                Travel <form:checkbox path="hobbies" value="travel"/>
                Programming <form:checkbox path="hobbies" value="programming"/>
            </p>
            <p>
                <label>Gender : </label>
                Male <form:radiobutton path="gender" value="male"/>
                Female <form:radiobutton path="gender" value="female"/>
            </p>
            <p>
                <input type="submit" value="Register">
            </p>
        </div>
    </form:form>


</body>
</html>
