<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../template/header.jsp" %>

<main id="catalog" class="catalogo">
    <section id="catalog-list">
        <div class="container">
            <h2>Catálogo</h2>
            
            <table>
				<thead>
				<tr>
				<th>Comprar</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${produtos}" var="produto">
				<tr>
				<td>
				<!-- Adicionando o produto no carrinho de compras -->
				<form action="<c:url value="/carrinho/adicionar"/>" method="POST">
				
				<input type="hidden" name="item.produto.id" value="${produto.id_produto}"/>
				<input class="qtde" name="item.quantidade" value="1"/>
				<button type="submit">Comprar</button>
				</form>
				</td>
				</tr>
				</c:forEach>
				</tbody>
				</table>           
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
			                        <li><a href="#"><span class="glyphicon glyphicon-eye-open"></span></a></li>
			                        <li><a href="#"><span class="glyphicon glyphicon-edit"></span></a></li>
			                    </ul>
			                    <div class="item-img" style="background: url(${produto.imagem}) no-repeat;"></div>
			                    <h4>${produto.descricao}</h4>
			                    <div class="price"><span class="value">${produto.preco}</span> à vista</div>
			                </article>
						</c:forEach>					
					</c:otherwise>
				</c:choose>
                <article class="item " data-item="1">
                    <ul class="options">
                        <li><a href="#" class="open_item"><span class="glyphicon glyphicon-eye-open"></span></a></li>
                        <li><a href="#" class="edit_item"><span class="glyphicon glyphicon-edit"></span></a></li>
                    </ul>
                    <div class="item-img" style="background: url(${pageContext.request.contextPath}/theme/images/catalogo/produto01.png) no-repeat;"></div>
                    <h4>Relógio</h4>
                    <div class="price"><span class="value">$ 44.690,00</span> à vista</div>
                </article>
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