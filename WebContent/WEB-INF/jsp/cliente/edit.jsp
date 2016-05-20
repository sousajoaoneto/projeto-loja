<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/theme/css/bootstrap.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/theme/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>

<div class="container" style="padding-top:50px">
		<h1>Editar</h1>
		<form class="form" action="${pageContext.request.contextPath}/cliente/atualizar" method="post">
			<div class="form-group">
				<label for="codigo">C�digo</label>
				<input type="text" class="form-control" id="codigo" value="${cliente.codigo}" disabled/>
				<input type="hidden" name="cliente.codigo" value="${cliente.codigo}" />
			</div>
			<div class="form-group">
				<label for="nome">Nome</label>
				<input type="text" class="form-control" name="cliente.nome" id="nome" value="${cliente.nome}" />
			</div>
			<div class="form-group">
				<label for="cpf">CPF</label>
				<input type="text" class="form-control" id="cpf" value="${cliente.cpf}" disabled />
				<input type="hidden" name="cliente.cpf" value="${cliente.cpf}" />
			</div>
			<div class="form-group">
				<label for="rg">RG</label>
				<input type="text" class="form-control" name="cliente.rg" id="rg" value="${cliente.rg}"/>
			</div>
			<button type="submit" class="btn btn-primary">Salvar <span class="glyphicon glyphicon-send"></span></button>
		</form>
	</div>

</body>
</html>