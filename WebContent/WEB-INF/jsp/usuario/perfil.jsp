<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../template/header.jsp"%>
	
<main id="perfil" class="content">
	<section id="dados">
		<div class="container">        	
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
			<c:if test="${msg ne null}">
	            	<div class="alert alert-info">${msg}</div>
	            </c:if>
	            <h2 style="margin-bottom:80px">Perfil</h2>
	            
				<c:set var="usuario" value="${userSession.usuario}"/>
			    <div id="dadosUser">
			        <div class="dado"><span>${usuario.nome}</span></div>
			        <div class="dado"><span>${usuario.email}</span></div>
			        <div class="dado"><span>${usuario.cpf}</span></div>
			        <div class="dado"><span>${usuario.data_nasc}</span></div>	        
			    </div>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<footer>
			<div class="container">
				<p>Tigaragatiga SA | &copy; copyright 2016</p>
			</div>
		</footer>
	</section>
</main>
    
<%@ include file="../template/footer.jsp"%>