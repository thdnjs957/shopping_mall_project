<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
 		
			<table class="table" style="margin:100px 0;">
				  <thead>
				    <tr>
				      <th scope="col">이미지</th>
				      <th scope="col">상품명</th>
				      <th scope="col">옵션명</th>
				      <th scope="col">배송구분</th>				      
				      <th scope="col">판매가</th>
				      <th scope="col">수량</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items='${basketList }' var='list'>
					  	<tr>
					    	<th></th>
					    	<td>${list.productName }</td>
					    	<td>${list.optionName }</td>
					    	<td>기본 배송</td>
					    	<td>${list.price }</td>
					    	<td>${list.count }</td>
					  	</tr>
				  	</c:forEach>
				  </tbody>
				  
			</table>
			

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>