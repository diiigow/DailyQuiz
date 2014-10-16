<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
</head>
<body>

<h1>Olá, ${sessionScope.contextoAutenticado.membro.nome}.</h1>

    <c:if test="${sessionScope.contextoAutenticado.membro.aniversario}">
        <h3>${sessionScope.contextoAutenticado.membro.nome}, parabéns pelos
            seus ${sessionScope.contextoAutenticado.membro.idade.getYears()} anos de vida.</h3>
    </c:if>

</body>
</html>