<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>
    <c:choose>
		<c:when test="${empty pageTitle}">
			Wacther Clock | Tigaragatiga
		</c:when>
		<c:otherwise>
			${pageTitle}
		</c:otherwise>
	</c:choose>
    </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/css/style.css"/>

    <script src="${pageContext.request.contextPath}/theme/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/theme/js/jquery.min.js"></script>
</head>
<body>
	<c:set var="userType" scope="session" value="${userSession.usuario.tipo}"/>
    <header>
        <div class="container">
            <div class="nav-options pull-right">            
                <ul class="nav nav-right">                    
                    <c:choose>
						<c:when test="${userSession.isLogged()}">
							<li class="dropdown">
								<a href="#" id="user-nav">${userSession.usuario.nome} <img src="${pageContext.request.contextPath}/theme/images/icon-user-o.png" /></a>
								<ul class="user-nav-options" style="display:none">
									<li><a href="${pageContext.request.contextPath}/usuario/perfil">Ver perfil</a></li>
									<li><a href="${pageContext.request.contextPath}/pedidos">Meus Pedidos</a></li>
									<li class="divider"></li>
									<c:if test="${userType eq 'GERENTE'}">
										<li><a href="#" class="cad-product">Cadastrar Produto</a></li>
									</c:if>
									<li><a href="${pageContext.request.contextPath}/sair">Sair</a></li>
								</ul>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/cadastrar">Cadastrar-se</a></li>
		                    <li>
		                        <a href="#" id="login">Entrar</a>
		                        <form class="form-horizontal login" action="${pageContext.request.contextPath}/autenticar" method="post" style="display:none">
		                            <div class="form-group has-feedback">
		                                <div class="col-sm-12">
		                                    <input type="email" class="form-control" id="email" name="usuario.email" placeholder="Email" autofocus required />
		                                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		                                </div>
		                            </div>
		                            <div class="form-group has-feedback">
		                                <div class="col-sm-12">
		                                    <input type="password" class="form-control" id="password" name="usuario.senha" placeholder="Senha" required />
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
					<li><a href="#" id="shop" class="shop"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>		      
                </ul>
            </div>

            <div class="logo">
                <a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/theme/images/logo-dark.png" alt=""></a>
            </div>

            <nav class="navbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}">HOME</a></li>
                    <li><a href="${pageContext.request.contextPath}/catalogo">Catálogo</a></li>
                    <li><a href="#">Sobre Nós</a></li>
                </ul>
            </nav>

        </div>
    </header>
    <!-- END HEADER -->