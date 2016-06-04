<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/header.jsp" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	
<main id="order" class="pedidos">
    <section id="order-list">
        <div class="container">
        	<c:if test="${msg ne null}">
            	<div class="alert alert-info">${msg}</div>
            </c:if>
            <h2>Meus Pedidos</h2>	         
        </div>
        	
        <div class="container">
            <div class="list">
	            <c:choose>
					<c:when test="${empty pedidos}">
						<h1 style="color:#f00">Nenhum pedido encontrado</h1>
					</c:when>
					<c:otherwise>
						<c:forEach items="${pedidos}" var="pedido">
							<div class="item" data-item="${pedido.id_pedido}">
								<div class="item-img" style="background: url(${pageContext.request.contextPath}/theme/images/pedido.jpg) no-repeat;"></div>
								<div class="item-content">
									<h3><a href="#">Pedido - ${pedido.id_pedido}</a></h3>
									<div class="item-etapa">
										<div class="corpo_etapa ">
											<div class="etapa concluido"></div>
											<span>pedido efetuado</span>
										</div>                
										<div class="corpo_etapa">
											<div class="etapa concluido"></div>
											<span>pagamento confirmado</span>
										</div>                
										<div class="corpo_etapa"> 
											<div class="etapa"></div>
											<span>produto em transporte</span>
										</div>                
										<div class="corpo_etapa"> 
											<div class="etapa"></div>
											<span>produto entregue</span>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>					
					</c:otherwise>
				</c:choose>       
				         
            </div>
        </div>
                
        <footer>
            <div class="container"><p>Tigaragatiga SA | &copy; copyright 2016</p></div>
        </footer>
    </section>
</main>

<%@ include file="../template/footer.jsp" %>