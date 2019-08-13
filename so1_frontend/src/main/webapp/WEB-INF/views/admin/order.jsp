<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${pageContext.servletContext.contextPath }/assets/css/shop-admin.css" rel="stylesheet">
<!-- Bootstrap core JavaScript -->
<script	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery.min.js"></script>
<script	src="${pageContext.servletContext.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

</head>
<body>

	<div class="d-flex" id="wrapper">

		<!-- Sidebar -->
		<c:import url='/WEB-INF/views/admin/includes/sidebar.jsp'>
			<c:param name="active" value="shopping" />
		</c:import>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
				
			<!-- navigation -->
			<c:import url='/WEB-INF/views/admin/includes/navigation.jsp' />
			<!-- /navigation -->

			<div class="container">
				<br />
				<h4>관리자 주문 관리</h4>
				<table class="table" style="margin:30px 0;">
					  <thead>
					    <tr>
					      <th scope="col">주문자</th>
					      <th scope="col">주문날짜</th>
					      <th scope="col">주문번호</th>
					      <th scope="col">상태</th>
					      <th scope="col">상품명</th>
					      <th scope="col">상품 옵션</th>				      
					      <th scope="col">수량</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach items='${orderList }' var='list' varStatus="status">
						  	<tr>
						  		<td>${list.userName }</td>
						    	<td>${list.order_date }</td>
						    	<td>${list.ju_number }</td>
						    	<td>${list.status }</td>
						    	<td>${list.productName }</td>
						    	<td>${list.optionName}</td>
						    	<td>${list.count }</td>
						    <%-- 	<td>${list.name }</td>  --%>
						  	</tr>
					  	</c:forEach>
					  </tbody>
					  
				</table>
			
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->


	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>

</html>