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
 		<form name="result_form" action="${pageContext.servletContext.contextPath }/order/info" method="POST">
			<table class="table" style="margin:70px 0;">
				  <thead>
				    <tr>
				      <th scope="col"><input type="checkbox" name="chk_info" value=""></th>
				      <th scope="col">이미지</th>
				      <th scope="col">상품명</th>
				      <th scope="col">옵션명</th>
				      <th scope="col">배송구분</th>				      
				      <th scope="col">판매가</th>
				      <th scope="col">수량</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items='${basketList }' var='list' varStatus="status">
					  	<tr>
					  		<td><input type="checkbox" name="chk_info" value=""></td>
					    	<td>
					    		<input type="hidden" name="basketList[${status.index }].pro_option_no" value="${list.pro_option_no }">
						    	<input type="hidden" name="basketList[${status.index }].productName" value="${list.productName }">
						    	<input type="hidden" name="basketList[${status.index }].optionName" value="${list.optionName }">
						    	<input type="hidden" name="basketList[${status.index }].price" value="${list.price }">
						    	<input type="hidden" name="basketList[${status.index }].count" value="${list.count }">
					    	</td>
					    	<td>${list.productName }</td>
					    	<td>${list.optionName }</td>
					    	<td>기본 배송</td>
					    	<td>${list.price * list.count }</td>
					    	<td>${list.count }</td>
					    	
					  	</tr>
				  	</c:forEach>
				  </tbody>
				  
			</table>
				<input type="submit" class="btn btn-info" style="margin-bottom:40px;" value="상품 주문하기">
			</form>
			
			
			
			
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>