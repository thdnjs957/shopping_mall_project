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
<link
	href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css"
	rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->

	<div class="container">
		<div class="row">
			<!-- left_section -->
				<c:import url='/WEB-INF/views/includes/left_section.jsp' />
			<!-- left_section end -->
			
			<div class="col-lg-9">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">

						<div class="carousel-item active">
							<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath}/assets/images/main1.PNG" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath}/assets/images/main2.PNG" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="${pageContext.servletContext.contextPath}/assets/images/main3.PNG" alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"> 
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					 <span class="sr-only">Previous</span>
					</a> 
					<a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> 
					<span class="carousel-control-next-icon" aria-hidden="true"></span> 
					<span class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:forEach items='${productList }' var='vo'>
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a href="${pageContext.servletContext.contextPath }/product/${vo.category_no}/${vo.no}">
									<c:forEach items='${vo.pro_Image }' var='iList'>
							    			<img class="main-image" alt="상품 메인 이미지" src="${pageContext.request.contextPath}/assets-upload${iList.url }">  
									</c:forEach>
								</a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="${pageContext.servletContext.contextPath }/product/${vo.category_no}/${vo.no}">${vo.name }</a>
									</h4>
									<h5>${vo.price }</h5>
									<p class="card-text">
										${vo.summary }
									</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">
										&#9733; &#9733; &#9733;
										&#9733; &#9734;
									</small>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->

		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
