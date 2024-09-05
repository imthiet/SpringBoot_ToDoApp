<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/register.css'/>">
    <script>
        function validateForm() {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;

            if (password !== confirmPassword) {
                document.getElementById('passwordError').textContent = "Passwords do not match.";
                return false;
            }
            document.getElementById('passwordError').textContent = "";
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h2>Register</h2>

    <c:if test="${not empty errorMessage}">
        <p class="error-message">${errorMessage}</p>
    </c:if>

    <c:if test="${not empty successMessage}">
        <p class="success-message">${successMessage}</p>
        <p>Redirecting to <a href="${pageContext.request.contextPath}/login">login</a> page.</p>
    </c:if>

    <form action="${pageContext.request.contextPath}/register" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
            <p id="passwordError" class="error-message"></p>
        </div>
        <div class="form-group">
            <button type="submit">Register</button>
        </div>
    </form>

    <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a>.</p>
</div>
</body>
</html>
