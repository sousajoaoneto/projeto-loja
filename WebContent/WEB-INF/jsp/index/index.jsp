<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="../template/header.jsp" %>

    <main class="home">
        <section id="banner-top" style="padding:100px">
            <div class="container">
	            <h4 style="color:#f00">
	            <c:choose>
					<c:when test="${userSession.isLogged()}">
						Ol� ${userSession.usuario.getEmail()}
					</c:when>
					<c:otherwise>
						N�o tem user
					</c:otherwise>
				</c:choose>
				</h4>   
            </div>
        </section>
        <section id="watches">
            <div class="item silver">prata</div>
            <div class="item gold">ouro</div>
            <div class="item smart">smart</div>
            <div class="item hand">de m�o</div>
        </section>
        <section id="pastime">
            <div class="container">
                <div class="col-sm-6 col-sm-offset-3">
                    <h4>Reinvente sua forma de ver<br/>o tempo passar</h4>
                    <span></span>
                </div>
            </div>
        </section>
        <section id="footer">
            <div class="container">
                <img src="./theme/images/logo-light-v.png" alt="" />
            </div>
            <footer>
                <div class="container"><p>Tigaragatiga SA | &copy; copyright 2016</p></div>
            </footer>
        </section>
    </main>
    
<%@ include file="../template/footer.jsp" %>