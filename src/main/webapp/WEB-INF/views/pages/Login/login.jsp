<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>

<div class="row bs-docs-section">
    <div class="col-lg-4">
        <form col="12" class="form-horizontal" method="post" action="<c:url value="/Login"/>">




            <fieldset>
                <legend>Login</legend>

                <c:if test="${not empty erro}">
                    <div class="alert alert-dismissable alert-warning">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <h4>Atenção!</h4>
                        <p>${erro}.</p>
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>

                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="email" id="inputEmail" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>

                    <div class="col-lg-10">
                        <input type="password" class="form-control" name="senha" id="inputPassword"
                               placeholder="Password">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>