<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/register.css'/>">
</head>
<body>
<div class="container">
    <h2>Login</h2>

    <c:if test="${not empty error}">
        <p class="error-message">Invalid username or password.</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <button type="submit">Login</button>
        </div>
    </form>

    <p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a>.</p>
</div>
</body>
</html>
