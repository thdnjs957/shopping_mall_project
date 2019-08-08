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
<script>

	$(document).ready(function() {

	    $('#summernote').summernote({
	            height: 300,                 // set editor height
	            minHeight: null,             // set minimum height of editor
	            maxHeight: null,             // set maximum height of editor
	            focus: true                  // set focus to editable area after initializing summernote
	    });
	    
	    $("#makeOption").click(function(e){
	    	e.preventDefault();
	    	optionName = $("").val();
		    optionValue = $("").val();
		    
	    });
	
          // 항목추가 버튼 클릭시
           $(".addBtn").click(function(e){
          	  e.preventDefault();

          	  var clickedRow = $(this).parent().parent(); 
              var cls = clickedRow.attr("class"); //class가 있는 요소 오브젝트로 담김 : item
              var newrow = clickedRow.clone(); //tr복사
              
			  newrow.find("td:last").html("<button class='btn btn-info delBtn'>삭제</button>"); //마지막 td요소에 삭제버튼 추가
              newrow.insertAfter($("#table ."+cls+":last"));	// id가 table인 요소 안의 마지막 class인 요소 선택

          });

          // 삭제버튼 클릭시
          $(document).on("click",".delBtn",function(e){
          	e.preventDefault();
              var clickedRow = $(this).parent().parent();
              clickedRow.remove();
          }); 
          
          $(document).on("click",".addValueBtn",function(e){
          	e.preventDefault();
          	var clickedRow = $(this).parent();
          	
          	console.log(clickedRow.find('input'));
          	var tag = "<input id='option_master' class='form-control' placeholder='예시)블루' name='option_value'>";
          	clickedRow.append(tag);
          }); 
	      
          $(document).on("click","#makeOption",function(e){
            	e.preventDefault();
                var nameList = new Array();
           	    $("input[name=option_name]").each(function(index, item){
           	    	nameList.push($(item).val());
           	    });
           	    
           		 var valueList = new Array();
        	    $("input[name=option_value]").each(function(index, item){
        	    	valueList.push($(item).val());
        	    });
				           	    
           	    console.log(nameList,valueList);
          }); 
		
         //등록 이미지 등록 미리보기
          function readInputFile(input) {
              if(input.files && input.files[0]) {
                  var reader = new FileReader();
                  reader.onload = function (e) {
                      $('#preview').append("<img src="+ e.target.result +">");
                  }
                  reader.readAsDataURL(input.files[0]);
              }
          }
           
          $(".inp-img").on('change', function(){
              readInputFile(this);
          });
           
          // 등록 이미지 삭제 ( input file reset )
          function resetInputFile($input, $preview) {
              var agent = navigator.userAgent.toLowerCase();
              if((navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1)) {
                  // ie 일때
                  $input.replaceWith($input.clone(true));
                  $preview.empty();
              } else {
                  //other
                  $input.val("");
                  $preview.empty();
              }       
          }
	});

</script>

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
               		 <input type="radio" name="is_show" value="true" checked="checked"> 진열함<br>
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
					<input type="file" name="main-image" class="inp-img" accept=".gif, .jpg, .png"> 
					<h6>추가 이미지</h6>
					<input type="file" name="sub-image1" class="inp-img" accept=".gif, .jpg, .png"> 
					<input type="file" name="sub-image2" class="inp-img" accept=".gif, .jpg, .png"> 
			
					<table id="table">
				        <tr>
				            <td>옵션 명</td>
				            <td>옵션 값</td>
				        </tr>
				
				        <tr class="item">
				            <td>
				            	<input type="text" name="option_name" size="15" placeholder="예시)색상"/>
				            </td>
				            <td>
				            	<input type="text" name="option_value" placeholder="예시)블랙">
				            	<button class="btn btn-info addValueBtn">값 추가</button>
				            </td>
				
				            <td><button class="btn btn-info addBtn">+</button></td>
				        </tr>
					</table>
					
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