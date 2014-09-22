<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Membro</title>
</head>
<body>
    <form method="post">
        <label>Nome:</label>
        <input type="text"/>
        <label>Email:</label>
        <input type="text"/>
        <label>Senha</label>
        <input type="password"/>
        <label>Data de Nascimento:</label>
        <input type="date"/>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
