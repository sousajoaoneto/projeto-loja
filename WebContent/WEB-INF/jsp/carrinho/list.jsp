<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
	                <li class="item" data-item="0">
	                    <a href="#" class="pull-right remove"><span class="glyphicon glyphicon-remove"></span></a>
	                    <img src="${pageContext.request.contextPath}/theme/images/watch-gold.jpg" class="item-img" />
	                    <p class="item-title">Title</p> <span class="badge item-price">R$ 0,00</span>
	                </li>
	            </ul>
	            
	        </div>
	        <h5>Total <span class="badge total-price"><fmt:formatNumber type="currency" value="${carrinho.total }"/></span></h5>
	        <a href="#" class="buy"><button class="btn btn-primary">Finalizar compra</button></a>
        </c:if>
    </div>
	<!-- END CART -->