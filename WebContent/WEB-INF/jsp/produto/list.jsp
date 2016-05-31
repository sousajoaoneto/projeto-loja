<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <select name="tecnologia" id="tecnologia">
                <option value="tec-all">Tecnologia</option>
                <option value="analogico">Analógico</option>
                <option value="digital">Digital</option>
                <option value="ambos">Ambos</option>
            </select>
            <select name="tipo" id="tipo">
                <option value="tipo-all">Tipo</option>
            </select>
            <select name="genero" id="genero">
                <option value="gen-all">Gênero</option>
                <option value="masculino">Masculino</option>
                <option value="feminino">Feminino</option>
            </select>
        </div>
        <div class="container">
            <div class="list">
	            <c:choose>
					<c:when test="${empty produtos}">
						<h1>Sem produtos</h1>
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