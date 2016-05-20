<%@page import="br.edu.fjn.model.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes - Lista</title>
<link href="${pageContext.request.contextPath}/theme/css/bootstrap.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/theme/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>	
	<div class="container" style="padding-top:50px">
	
	<h2>Lista de Clientes</h2>
		
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Nome</th>
				<th>RG</th>
				<th>CPF</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty clientesList}">
					<tr>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${clientesList}" var="cliente">
						<tr>
							<td>${cliente.nome}</td>
							<td>${cliente.rg}</td>
							<td>${cliente.cpf}</td>
							<td>
								<a href="editar/${cliente.codigo}"><button class="btn btn-warning">Editar</button></a>
								<a href="deletar/${cliente.codigo}"><button class="btn btn-danger">Remover</button></a>
							</td>
						</tr>
					</c:forEach>					
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="4"></td>
			</tr>			
		</tbody>
	</table>	
	</div>
	<div class="container" style="padding-top:100px">
		<form class="form" action="salvar" method="post">
			<div class="form-group">
				<label for="codigo">Código</label>
				<input type="text" class="form-control" name="cliente.codigo" id="codigo" />
			</div>
			<div class="form-group">
				<label for="nome">Nome</label>
				<input type="text" class="form-control" name="cliente.nome" id="nome" />
			</div>
			<div class="form-group">
				<label for="cpf">CPF</label>
				<input type="text" class="form-control" name="cliente.cpf" id="cpf" />
			</div>
			<div class="form-group">
				<label for="rg">RG</label>
				<input type="text" class="form-control" name="cliente.rg" id="rg" />
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar Novo</button>
		</form>
	</div>
</body>
</html>