<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>

<form method="post">
    <h2>Login</h2>
    <label>Email</label>
    <input type="text" name="email" placeholder="email" required autofocus>
    <label>Senha</label>
    <input type="password" name="senha" placeholder="senha" required>
    <button type="submit">Entrar</button>
    <br/>
    <a href="/cadastro">Não é membro? clique aqui</a>
</form>

</body>
</html>