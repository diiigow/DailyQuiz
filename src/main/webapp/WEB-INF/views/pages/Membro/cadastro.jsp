<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cadastro de Membro</title>
</head>
<body>
<div class="row bs-docs-section col-lg-offset-2 col-lg-8 col-lg-pull-2 well bs-component">

    <form:form modelAttribute="formulario" method="post" class="form-horizontal">
        <fieldset>
            <legend>Cadastro de Membro</legend>

            <div class="form-group">
                <label for="inputNome" class="col-lg-3 control-label">Nome</label>

                <div class="col-lg-9">
                    <form:input path="nome" type="text" class="form-control" id="inputNome" placeholder="Nome"/>
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail" class="col-lg-3 control-label">Email</label>

                <div class="col-lg-9">
                    <form:input path="email" type="email" class="form-control" name="email" id="inputEmail"
                                placeholder="Email"/>
                </div>
            </div>

            <div class="form-group">
                <label for="inputPassword" class="col-lg-3 control-label">Password</label>

                <div class="col-lg-9">
                    <form:password path="senha" class="form-control" name="senha" id="inputPassword"
                                   placeholder="Password"/>
                </div>
            </div>

            <div class="form-group">
                <label for="inputDataNascimento" class="col-lg-3 control-label">Nascimento</label>

                <div class="col-lg-9">
                    <form:input path="dataNascimento" type="date" class="form-control" name="dataNascimento"
                                id="inputDataNascimento"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-9 col-lg-offset-3">
                    <a href="<c:url value="/"/>" class="btn btn-default">Cancelar</a>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
            </div>
        </fieldset>
    </form:form>

    <c:if test="${not empty erro}">
        <div class="alert alert-dismissable alert-warning">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <h4>Atenção!</h4>

            <p>${erro}!</p>
        </div>
    </c:if>

</div>
</body>
</html>
