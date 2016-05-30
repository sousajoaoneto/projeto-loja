<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="../template/header.jsp" %>
    
    <main id="sign" class="content">
        <section id="form">
            <div class="container">

                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                	<h2>Cadastro</h2>
                    <form class="form-horizontal light cadUser" action="${pageContext.request.contextPath}/usuario/salvar" method="post">
                        <div class="form-group has-feedback">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="firstName" placeholder="Nome" name="usuario.nome" autofocus required />
                                <span class="glyphicon glyphicon-hand-left form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="cpf" name="usuario.cpf" placeholder="CPF" required />
                                <span class="glyphicon glyphicon-hand-left form-control-feedback"></span>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="birth" name="usuario.data_nasc" placeholder="Data NAscimento" required />
                                <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="address" name="endereco.rua" placeholder="Endereço" required />
                                <span class="glyphicon glyphicon-road form-control-feedback"></span>
                            </div>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="address_number" name="endereco.numero" placeholder="Número" required />
                                <span class="glyphicon glyphicon-road form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-3">
                                <input type="text" class="form-control cep" id="cep" name="cidade.cep" placeholder="CEP" required />
                            </div>
                            <div class="col-sm-3">
                                <input type="text" class="form-control uf" id="state" name="estado.nome" placeholder="UF" required />
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control cidade" id="city" placeholder="Cidade" name="cidade.nome" required />
                                <span class="glyphicon glyphicon-globe form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-12">
                                <input type="email" class="form-control" id="email2" name="usuario.email" placeholder="E-mail" required />
                                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="username" name="usuario.username" placeholder="Nome de Usuário" required />
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-12">
                                <input type="password" class="form-control" id="password2" name="usuario.senha" placeholder="Senha" required />
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-9">
                                <div class="checkbox">
                                    <input type="checkbox" required> Aceito os <a href="#">termos</a> e <a href="#">políticas de uso</a>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button type="submit" class="btn btn-primary">Cadastrar</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-sm-3"></div>
            </div>
            <footer>
                <div class="container"><p>Tigaragatiga SA | &copy; copyright 2016</p></div>
            </footer>
        </section>
    </main>
    
    <%@ include file="../template/footer.jsp" %>