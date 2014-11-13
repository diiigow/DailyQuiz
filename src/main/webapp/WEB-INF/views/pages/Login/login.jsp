<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>

<div class="row bs-docs-section col-lg-offset-2 col-lg-6 well bs-component">
    <div class="col-lg-12">
        <form class="form-horizontal" method="post" action="<c:url value="/Login"/>">
            <fieldset>
                <legend>Login</legend>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-10">
                        <input type="email" class="form-control" name="email" id="inputEmail" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Senha</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" name="senha" id="inputPassword" placeholder="Password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-10">
                        <a href="<c:url value="/Cadastro"/>" class="btn btn-link" style="padding-left: 0px">Não é membro? clique aqui!</a>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="submit" class="btn btn-primary">Entra no Sistema</button>
                    </div>
                </div>
            </fieldset>
        </form>

        <c:if test="${not empty erro}">
            <div class="alert alert-dismissable alert-warning">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <h4>Atenção!</h4>
                <p>${erro}.</p>
            </div>
        </c:if>

    </div>
</div>
</body>
</html>