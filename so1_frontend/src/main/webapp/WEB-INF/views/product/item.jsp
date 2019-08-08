<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css" rel="stylesheet">
	<!-- Bootstrap core JavaScript -->
	<script	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery.min.js"></script>
	<script	src="${pageContext.servletContext.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
	
</head>
<style>
	body{margin-top:50px;}
	.img-thumbnail.main{
		width:300px;	
	}
	
	.img-thumbnail.sub{
		width:150px;
	}
	
	.left-content{
		float:left;
	}
	.right-content{
		margin-left:400px;
		height:650px;
	}
	
</style>

<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<!-- left_section -->
				<c:import url='/WEB-INF/views/includes/left_section.jsp' />
			<!-- left_section end -->

			<div class="col-lg-9">
				<div style="margin-top:110px;">
					<div class="left-content">
						<c:forEach items='${vo.pro_Image }' var='iList'>
							<c:choose>
								<c:when test="${iList.is_main }">
									<div>
										<img alt="상품  메인 이미지" src="${pageContext.request.contextPath}/assets-upload${iList.url }" class="img-thumbnail main">
									</div>
								</c:when>
								<c:otherwise>
									<img alt="상품  서브 이미지" src="${pageContext.request.contextPath}/assets-upload${iList.url }" class="img-thumbnail sub">  
								</c:otherwise>
							</c:choose>	
						</c:forEach>
					</div> 
					<div class="right-content">
					
						<h3 class="card-title">상품명 : ${vo.name }</h3>
						<br />
						<h4>가격 : ${vo.price } </h4>
						<br />
						<p class="card-text">
							 설명 : ${vo.summary }
						</p>
						<p>
							<c:forEach items='${vo.option }' var='option_list'>
								<h6>${option_list.name }</h6>
								<select class="form-control">
									<c:forEach items="${option_list.option_ma}" var="option_ma_list">
										  <option>${option_ma_list.value}</option>
									</c:forEach>
								</select>
								<br />
							</c:forEach>
						</p>
					</div>
					<div class="detail">
						<p>
							${vo.detail }
						</p>
					</div>
					
					
				</div>
				<!-- /.card -->

			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>