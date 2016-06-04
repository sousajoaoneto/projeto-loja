<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../template/header.jsp" %>

<main id="catalog" class="catalogo">
    <section id="catalog-list">
        <div class="container">
        	<c:if test="${msg ne null}">
            	<div class="alert alert-info">${msg}</div>
            </c:if>
            <h2>Catálogo</h2>	         
        </div>
        	<div class="nav-catalogo">
        	<form class="form-horizontal search-produtos" action="${pageContext.request.contextPath}/produto/pesquisar" method="post">
				<input type="search" name="descricao" placeholder="nome do produto" />           		
           		<select name="genero" required>
           			<option value="MASCULINO">Masculino</option>
           			<option value="FEMININO">Feminino</option>
           		</select>
            	<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span> Pesquisar</button>
            	<a href="${pageContext.request.contextPath}/catalogo"class="btn btn-default">Mostrar todos os produtos</a>
        	</form>	
        </div>
        <div class="container">
            <div class="list">
	            <c:choose>
					<c:when test="${empty produtos}">
						<h1>Nenhum produto encontrado</h1>
					</c:when>
					<c:otherwise>
						<c:forEach items="${produtos}" var="produto">
							<article class="item" data-item="${produto.id_produto}">
			                    <ul class="options">
			                        <li><a href="#" class="open_item"><span class="glyphicon glyphicon-eye-open"></span></a></li>
			                        <c:if test="${userType eq 'GERENTE'}">
                        				<li><a href="#" class="edit_item"><span class="glyphicon glyphicon-edit"></span></a></li>
                        			</c:if>
			                    </ul>
			                    <div class="item-img" style="background: url(${produto.imagem}) no-repeat;"></div>
			                    <h4>${produto.descricao}</h4>
			                    <div class="price"><span class="value">${produto.preco}</span> à vista</div>
			                    
			                    <!-- Adicionando o produto no carrinho de compras -->
								<form class="form-horizontal" action="${pageContext.request.contextPath}/carrinho/adicionar" method="post">				
									<input type="hidden" name="codigo" value="${produto.id_produto}"/>
									<div class="form-group">
				                        <div class="col-sm-6">
				                            <input type="number" class="qtde form-control"  name="quantidade" value="1"/>
				                        </div>
				                        <div class="col-sm-6">
				                            <button type="submit" class="btn btn-primary buy">Comprar</button>
				                        </div>
				                    </div>									
								</form>
			                </article>
						</c:forEach>					
					</c:otherwise>
				</c:choose>                
            </div>
        </div>
        
        <div id="product-show" class="popup">
            Mostrar
        </div>
        
        <footer>
            <div class="container"><p>Tigaragatiga SA | &copy; copyright 2016</p></div>
        </footer>
    </section>
</main>

<%@ include file="../template/footer.jsp" %>