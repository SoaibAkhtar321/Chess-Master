<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Confirmation</title>
</head>
<body>
    <h1>Registration Successful</h1>

    <!-- Display Username and Email using EL -->
    <p>Username: ${username}</p>
    <p>Email: ${email}</p>

    <!-- Add a conditional message using JSTL -->
    <c:if test="${not empty username}">
        <p>Thank you for registering, ${username}!</p>
    </c:if>

    <a href="userRegistration">Go back to Registration</a>
</body>
</html>
