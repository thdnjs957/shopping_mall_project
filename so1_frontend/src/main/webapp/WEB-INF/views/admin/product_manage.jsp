<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<script src="${pageContext.servletContext.contextPath }/assets/js/manage.js"></script>
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
				<h3 class="mt-4">관리자 상품 등록</h3>
				<form:form modelAttribute="productVo" action="${pageContext.servletContext.contextPath }/admin/product/register" name="product_form" method="post" enctype="multipart/form-data">
					
					<span class="input_name">상품명 : </span>
					 <input id="name" type="text" class="form-control" placeholder="상품명" name="name" required autofocus />
               		 <spring:hasBindErrors name="productVo">
	                   <c:if test="${errors.hasFieldErrors('name') }">
	                      <p style="font-weight:bold; color:red; text-align:left; padding:0">
	                           <spring:message 
	                             code="${errors.getFieldError( 'name' ).codes[0] }"                  
	                             text="${errors.getFieldError( 'name' ).defaultMessage }" />
	                      </p> 
	                  </c:if>
             		  </spring:hasBindErrors> 
               		 <span class="input_summary">상품 요약 설명 : </span>
					 <input id="input_summary" type="text" class="form-control" placeholder="상품요약설명" name="summary" required>
               		 <span class="input_price">판매가 : </span>
					 <input id="input_price" class="form-control" placeholder="판매가" name="price" required>
					  <spring:hasBindErrors name="productVo">
	                   <c:if test="${errors.hasFieldErrors('price') }">
	                      <p style="font-weight:bold; color:red; text-align:left; padding:0">
	                           <spring:message 
	                             code="${errors.getFieldError( 'price' ).codes[0] }"                  
	                             text="${errors.getFieldError( 'price' ).defaultMessage }" />
	                     </p> 
	                  </c:if>
             		  </spring:hasBindErrors> 
					 
               		 <span class="input_detail">상품 상세 설명 : </span>
               		 <textarea name="detail" id="summernote"></textarea>
               		 
               		 <br />
               		 
               		 <span class="input_summary">진열 여부 : </span>
               		 <input type="radio" name="is_show" value="true" checked="checked"> 진열함
  					 <input type="radio" name="is_show" value="false"> 진열안함<br>
               			 
	            	<div id="categoryBox" style="margin-bottom:20px;">
						<span class="inputCategory">상품분류 :</span> 
						<select name="category_no" class="form-control" style="width: 150px;">
							<c:forEach items="${categoryList}" var="list">
								<option value="${list.no}">${list.name}</option>
							</c:forEach>
						</select> 
					</div>
					
					<h6>메인 이미지</h6>
					<div id="preview">
					</div>
					
				   <input type="image" class="img" id="img1" src="${pageContext.servletContext.contextPath }/assets/images/placeholder.jpg" width="230px"/>
				   <input type="file" id="my_file" name="main-image" class="inp-img" style="display: none;" />

					<h6>추가 이미지</h6>
					<input type="image" class = "img" id="img2" src="${pageContext.servletContext.contextPath }/assets/images/placeholder.jpg" width="230px"/>
					<input type="file" id="my_file" name="sub-image1" class="inp-img" style="display: none;" />
					
					<input type="image" class = "img" id="img3" src="${pageContext.servletContext.contextPath }/assets/images/placeholder.jpg" width="230px"/>
					<input type="file" id="my_file" name="sub-image2" class="inp-img" style="display: none;" />
					
				    <div class="optionTable">
				        	<table id="tableId" border = "1" style="width:1000px;">
				        		<thead>
				        			<tr>
				        				<th>옵션명</th>
				        				<th>옵션값</th>
				        			</tr>
				        		</thead>
				        		<tbody id = "optionTBody">
				        			<tr class="optionTr"  >
				        				<td class="tOptioNameArea" optionGroup = 0>
				        					<input type="text" name="option[0].name" class="option_name" size="15" placeholder="예시)색상"/>
				        				</td>
				        				<td class="tOptionValueArea">
				        					<div class="dOptionValueArea" style="float:left;">
				        						<ul class="ulOptionValueArea">
				        							<li>
				        								<input type="text" name="option[0].option_ma[0].value" class="option_value"  placeholder="예시)블랙">
				        							</li>
				        						</ul>
				        					</div>

				        					<button class="btn btn-info addValueBtn">값 추가</button>
				        				</td>

				        				<button class="btn btn-info addBtn">+</button>
				        			</tr>
				        		</tbody>
	
				        	</table>
				        
				     </div>
				     
				     <div class="optionResult">
				     </div>

					<button class="btn btn-sm btn-info btn-block" id="makeOption" style="width:100px; margin:20px;">옵션 품목 만들기</button>
                	<button class="btn btn-lg btn-primary btn-block" type="submit" id="regist_button" style="width:200px;">상품 등록</button>

				</form:form>
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