<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Wacther Clock | Tigaragatiga</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/style.css"/>

    <script src="${pageContext.request.contextPath}/theme/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/theme/js/jquery.min.js"></script>
</head>
<body>
	<!-- GET USER FROM SESSION -->
	<c:set var="user" scope="session" value="${userSession}"/>
    <header>
        <div class="container">
            <div class="nav-options pull-right">
                <ul class="nav">
                    <li><a href="#"><img src="${pageContext.request.contextPath}/theme/images/icon-shop.png" /></a></li>
                    
                    <c:choose>
						<c:when test="${user ne null}">
							<li><a href="${pageContext.request.contextPath}/sair">Sair</a></li>                  
                    		<li><a href="#"><img src="${pageContext.request.contextPath}/theme/images/icon-user-o.png" /></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/cadastrar">Cadastrar-se</a></li>
		                    <li>
		                        <a href="#" id="login">Entrar</a>
		                        <form class="form-horizontal login" action="autenticar" method="post" style="display:none">
		                            <div class="form-group has-feedback">
		                                <div class="col-sm-12">
		                                    <input type="email" class="form-control" id="email" name="usuario.email" placeholder="Email">
		                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		                                </div>
		                            </div>
		                            <div class="form-group has-feedback">
		                                <div class="col-sm-12">
		                                    <input type="password" class="form-control" id="password" name="usuario.senha" placeholder="Senha">
		                                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
		                                </div>
		                            </div>
		                            <div class="form-group">
		                                <div class="col-sm-12">
		                                    <button type="submit" class="btn btn-default">Entrar</button>
		                                </div>
		                            </div>
		                        </form>
		                    </li>			
						</c:otherwise>
					</c:choose>                    
                </ul>
            </div>

            <div class="logo">
                <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/theme/images/logo-dark.png" alt=""></a>
            </div>

            <nav class="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}">HOME</a></li>
                    <li><a href="#">Cat�logo</a></li>
                    <li><a href="#">Categorias</a></li>
                    <li><a href="#">Sobre N�s</a></li>
                </ul>
            </nav>

        </div>
    </header>
    <!-- END HEADER -->