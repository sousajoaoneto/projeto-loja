<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../template/header.jsp" %>

<main id="section-login" class="content">
    <section id="form">
        <div class="container">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <h2>Entrar</h2>
                <form class="form-horizontal light" action="autenticar" method="post">
                    <div class="form-group has-feedback">
                        <div class="col-sm-12">
                            <input type="email" class="form-control" id="email2" name="usuario.email" placeholder="E-mail">
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <div class="col-sm-12">
                            <input type="password" class="form-control" id="password2" name="usuario.senha" placeholder="Senha">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-default">Entrar</button>
                        </div>
                        <div class="col-sm-9">
                            Não tem cadastro? <a href="cadastrar.html">Cadastre-se!</a>
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