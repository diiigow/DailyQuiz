<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Membro</title>
</head>
<body>
    <form method="post">
        <label>Nome:</label>
        <input type="text" name="nome"/>
        <br/>
        <label>Email:</label>
        <input type="text" name="email"/>
        <br/>
        <label>Senha</label>
        <input type="password" name="senha"/>
        <br/>
        <label>Data de Nascimento:</label>
        <input type="date" name="dataNascimento"/>
        <br/>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
