<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<!-- START CART -->
    <div id="cart" style="display:block" >
        <a href="#" class="pull-left close shop"><span class="glyphicon glyphicon-chevron-right"></span></a>
        <h4 class="title">Meu carrinho</h4>
        <c:if test="${empty carrinho or carrinho.totalDeItens eq 0 }">
			<span>Você não possui itens no seu carrinho</span>
		</c:if>
		<c:if test="${carrinho.totalDeItens > 0 }">
		
	        <div class="itens scroll-y">
	        	<strong>Itens:</strong> ${carrinho.totalDeItens }
				<ul id="cart-list">
					<c:forEach items="${carrinho.itens}" var="item" varStatus="s">
		                <li class="item" data-item="0">
		                    <a href="${pageContext.request.contextPath}/carrinho/remover/${s.index}" class="pull-right remove"><span class="glyphicon glyphicon-remove"></span></a>
		                    <img src="${item.produto.imagem}" class="item-img" />
		                    <p class="item-title">${item.produto.descricao}</p> <span class="badge item-price"><fmt:formatNumber type="currency"
value="${item.produto.preco}" currencySymbol="R$"/></span>
							 <span class="badge bg-info item-qtd">Qtd ${item.quantidade}</span>
		                </li>
	                </c:forEach>
	            </ul>
	            
	        </div>
	        <h5>Total <span class="badge total-price"><fmt:formatNumber type="currency" value="${carrinho.total}" currencySymbol="R$"/></span></h5>
	        <a href="${pageContext.request.contextPath}/pedidos/finalizar" class="buy"><button class="btn btn-primary">Finalizar compra</button></a>
        </c:if>
    </div>
	<!-- END CART -->