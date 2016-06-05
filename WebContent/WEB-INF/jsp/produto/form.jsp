<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
    <!-- START FORM PRODUTOS -->
    <c:if test="${userType eq 'GERENTE'}">
    <div id="product-form" class="popup">
            <h4 class="title">Cadastrar Produto</h4>
            <form class="form-horizontal dark" method="post" action="${pageContext.request.contextPath}/produto/salvar">
            	
                <div class="form-group has-feedback">
                    <div class="col-sm-12">
                        <input type="text" class="form-control" id="descricao" name="produto.descricao" placeholder="Descrição" required>
                    </div>
                </div>
                
                <div class="form-group has-feedback">
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="modelo" name="modelo.descricao" placeholder="Modelo" list="modelos" required>
                        <datalist id="modelos">
                            <option value="Smart"></option>
                            <option value="Mão"></option>
                            <option value="Ouro"></option>
                            <option value="Prata"></option>
                            <option value="Diamante"></option>
                        </datalist>
                    </div>
                    <div class="col-sm-4">
                        <input type="number" class="form-control" id="estoque" name="produto.estoque" placeholder="Estoque" required>
                    </div>
                </div>
                
                <div class="form-group has-feedback">
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="preco" name="produto.preco" placeholder="Preço" required>
                    </div>
                    <div class="col-sm-4">
                        <select name="produto.genero" id="produto-genero" required>
                            <option value="MASCULINO">Masculino</option>
                            <option value="FEMININO">Feminino</option>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <select name="produto.tecnologia" id="produto-tecnologia" required>
                            <option value="DIGITAL">Digital</option>
                            <option value="ANALOGICO">Analógico</option>
                            <option value="AMBOS">Ambos</option>
                        </select>
                    </div>
                </div>

				
                <div class="form-group has-feedback">
                    <div class="col-sm-4">
                        <select name="cor.descricao" id="produto-cor" required>
                            <option value="branco">branco</option>
                            <option value="preto">preto</option>
                            <option value="dourado">Dourado</option>
                            <option value="prata">prata</option>
                        </select>
                    </div>
                </div>
				<div class="form-group has-feedback">
                    <div class="col-sm-12">
                        <input type="text" class="form-control" id="imagem" name="produto.imagem" placeholder="URL da imagem" required>
                    </div>
                </div>
                
                <div class="form-group">
                	<div class="col-sm-2">
                    	<button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                    <div class="col-sm-2">
                    	<a class="btn btn-default close-edit">Cancelar</a>
                    </div>
                </div>
            </form>
        </div>
        </c:if>
        <!-- END FORM PRODUTOS -->