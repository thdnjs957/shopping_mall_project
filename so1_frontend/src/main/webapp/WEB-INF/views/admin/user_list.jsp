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

			<div class="container-fluid" id="admin-register">
			<br />
				<h4>회원 조회</h4>
				
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">번호</th>
					      <th scope="col">이름</th>
					      <th scope="col">아이디</th>
					      <th scope="col">이메일</th>
					      <th scope="col">전화번호</th>
					      <th scope="col">성별</th>
					      <th scope="col">가입일</th>
					    </tr>
					  </thead>
					  <tbody>
					  <%-- <c:set var="count" value="${fn:length(productList) }"/> --%>
						  <c:forEach items='${userList }' var='vo' varStatus = "status">
						  	<tr>
						    	<th scope="row">${status.index+1 }</th>
						    	<td>${vo.name }</td>
						    	<td>${vo.id }</td>
						    	<td>${vo.email }</td>
						    	<td>${vo.phone }</td>
						    	<td>${vo.gender }</td>
						    	<td>${vo.join_date }</td>
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