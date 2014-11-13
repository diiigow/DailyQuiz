<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Dashboard</title>

    <style>
        .subtitulonovos {
            background-color: #10a062;
            height: 25px;
            color: #ffffff;
        }

        .subtituloRanking {
            background-color: #208dbe;
            height: 25px;
            color: #ffffff;
        }

        .subtituloRespondido {
            background-color: #6e1881;
            height: 25px;
            color: #ffffff;
        }
    </style>
</head>
<body>

<div>
    <h2>Olá, ${sessionScope.contextoAutenticado.membro.nome}.</h2>

    <c:if test="${sessionScope.contextoAutenticado.membro.aniversario}">
        <h3>${sessionScope.contextoAutenticado.membro.nome}, parabéns pelos
            seus ${sessionScope.contextoAutenticado.membro.idade.getYears()} anos de vida.</h3>
    </c:if>
</div>

<div class="col-lg-4">
    <div class="panel panel-success">
          <div class="panel-heading">
            <h3 class="panel-title"><span class="glyphicon glyphicon-edit"> Novos</span></h3>
        </div>
        <div class="subtitulonovos col-lg-8">
            <span>Nome</span>
        </div>
        <div class="subtitulonovos col-lg-4">
            <span>Expira Em:</span>
        </div>
        <div class="panel-body">
            <div class="col-lg-9"><a href="#">T-SQL e Novas funções</a></div>
            <div class="col-lg-3">2 dias</div>
            <div class="col-lg-9"><a href="#">Você conheçe UX?</a></div>
            <div class="col-lg-3">5 dias</div>
            <div class="col-lg-9"><a href="#">Falando sobre OO</a></div>
            <div class="col-lg-3">7 dias</div>
        </div>
    </div>
</div>

<div class="col-lg-4">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"><span class="glyphicon glyphicon-list-alt"> Ranking</span></h3>
        </div>
        <div class="subtituloRanking col-lg-8">
            <span>Membro</span>
        </div>
        <div class="subtituloRanking col-lg-4">
            <span>Pontuação</span>
        </div>
        <div class="panel-body">
            <div class="col-lg-12">
                <label style="width: 10%">01</label>
                <label style="width: 75%">Benzema</label>
                <label style="width: 10%">324</label>
            </div>

            <div class="col-lg-12">
                <label style="width: 10%">02</label>
                <label style="width: 75%">Messi</label>
                <label style="width: 10%">321</label>
            </div>

            <div class="col-lg-12">
                <label style="width: 10%">03</label>
                <label style="width: 75%">Jordi Alba</label>
                <label style="width: 10%">318</label>
            </div>

            <div class="col-lg-12">
                <label style="width: 10%">04</label>
                <label style="width: 75%">Pirlo</label>
                <label style="width: 10%">310</label>
            </div>

            <div class="col-lg-12">
                <label style="width: 10%">05</label>
                <label style="width: 75%">Di Maria</label>
                <label style="width: 10%">305</label>
            </div>

            <div class="col-lg-12">
                <label style="width: 10%">13</label>
                <label style="width: 75%">Diigow</label>
                <label style="width: 10%">189</label>
            </div>

        </div>
    </div>
</div>


<div class="col-lg-4">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><span class="glyphicon glyphicon-check"> Respondidos</span></h3>
        </div>
        <div class="subtituloRespondido col-lg-8">
            <span>Nome</span>
        </div>
        <div class="subtituloRespondido col-lg-4">
            <span>Pontuação</span>
        </div>
        <div class="panel-body"></div>
    </div>
</div>

</body>
</html>