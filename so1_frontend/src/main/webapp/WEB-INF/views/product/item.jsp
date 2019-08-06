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
</head>
<style>
	body{margin-top:50px;}

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
			
<!-- 	private Long no;
	
	@NotNull
	@Length(min=2)
	private String name;
	
	private String summary;
	
	@NotNull
	private int price;
	
	@NotNull
	private boolean is_show;
	
	private String detail;
	
	private int tot_stock;
	private String reg_date;
	private Long category_no;
	
	private List<ImageVo> pro_Image;
	
	@Valid
	private List<OptionVo> option;
	
	private List<ProductOptionVo> pro_option; -->

			<div class="col-lg-9">
				<div class="card mt-4">
					<img class="card-img-top img-fluid"
						src="http://placehold.it/900x400" alt="">
					<div class="card-body">
						<h3 class="card-title">${vo.name }</h3>
						<h4>${vo.price } </h4>
						<p class="card-text">
							${vo.summary }
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
				</div>
				<!-- /.card -->

				<div class="card card-outline-secondary my-4">
					<div class="card-header">Product Reviews</div>
					<div class="card-body">
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.
						</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.
						</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Omnis et enim aperiam inventore, similique necessitatibus neque
							non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
							Sequi mollitia, necessitatibus quae sint natus.
						</p>
						<small class="text-muted">Posted by Anonymous on 3/1/17</small>
						<hr>
						<a href="#" class="btn btn-success">Leave a Review</a>
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