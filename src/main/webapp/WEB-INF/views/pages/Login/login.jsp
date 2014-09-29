<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>

<form method="post" action="<c:url value="/Login"/>">
    <h2>Login</h2>
    <c:if test="${not empty erro}">
        <h3>${erro}</h3>
    </c:if>
    <input type="text" name="username" placeholder="username" required autofocus>
    <input type="password" name="senha" placeholder="senha" required>
    <button type="submit">Entrar</button>
</form>

</body>
</html>