<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
	<div class="col-lg-3">
			<h1 class="my-4">Wish Shop</h1>
			<div class="list-group">
					<c:forEach items='${categoryList }' var='vo'>
						<a href="${pageContext.servletContext.contextPath }/product/${vo.no}" class="list-group-item">${vo.name }</a>  
					</c:forEach>
			</div>
	</div>

  <!-- Bootstrap core JavaScript -->
  <script src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery.min.js"></script>
  <script src="${pageContext.servletContext.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    