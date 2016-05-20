<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="../template/header.jsp" %>
    
    <main id="sign" class="content">
        <section id="form">
            <div class="container">

                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                                  <h2>Cadastro</h2>
                    <form class="form-horizontal light" action="${pageContext.request.contextPath}/usuario/salvar" method="post">
                        <div class="form-group has-feedback">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="firstName" name="usuario.nome" placeholder="Nome" autofocus required />
                                <span class="glyphicon glyphicon-hand-left form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-12">
                                <input type="text" class="form-control" id="address" name="usuario.endereco" name="" placeholder="Endereço" required />
                                <span class="glyphicon glyphicon-road form-control-feedback"></span>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="cep" name="" placeholder="CEP" required />
                            </div>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" placeholder="UF" disabled />
                                <input type="hidden" class="form-control" id="state" name="" placeholder="UF" required />
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="city" placeholder="Cidade" required />
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
                                <input type="text" class="form-control" id="username" name="usuario.cpf" placeholder="Nome de Usuário" required />
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
                                    <input type="checkbox" required /> Aceito os <a href="#">termos</a> e <a href="#">políticas de uso</a>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <button type="submit" class="btn btn-default">Cadastrar</button>
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