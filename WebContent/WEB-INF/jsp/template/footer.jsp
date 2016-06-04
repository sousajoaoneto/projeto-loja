<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     
    <!-- START FOOTER -->
    
    <%@ include file="../produto/form.jsp" %>
        
    <div class="overlay" style="display: none"></div>
    
    <%@ include file="../carrinho/list.jsp" %>	

    <script src="${pageContext.request.contextPath}/theme/js/script.js"></script>
</body>
</html>