<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
	href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css"
	rel="stylesheet">
<!-- Bootstrap core JavaScript -->
<script
	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery.min.js"></script>
<script
	src="${pageContext.servletContext.contextPath }/assets/bootstrap/js/bootstrap.bundle.min.js"></script>
<script>
	$(document).ready(function() {
		
		$(document).on('click','.minus',function(e){
			var $input = $(this).parent().find('input');
			var count = parseInt($input.val()) - 1;
			count = count < 1 ? 1 : count;
			$input.val(count);
			$input.change();
			return false;
		});
		
		$(document).on('click','.plus',function(e){
			var $input = $(this).parent().find('input');
			$input.val(parseInt($input.val()) + 1);
			$input.change();
			return false;
		});
		
		$('.option_select').change(function() {
			
			var se = $(".option_select option:selected");
			
			//console.log(se.first().text());
			
			var result = '';
			if($(".option_select option:selected").last().val() != ''){ 
				
				se.each(function(index,item) {
					if(item.value == ''){
						alert('옵션값을 선택해주세요');
						return false;
					}
					else{
						result += item.text +'/';
					}
				});

				result = result.substr(0, result.length -1);
				
				var pro_option = $(".option_select option:selected").text();
				
				var tag = '<tr id = "pro_option_tr"><td>${vo.name }:'+result+'</td>'
		            tag += '<td style="width:80px;">'
		            tag+='<span class="minus">-</span>'
		            tag+='<input class="count_input" type="text" value="1"/>'
		            tag+='<span class="plus">+</span>'		
		           	tag+='</td>'
					tag+='<td class="right"><span class="quantity_price">${vo.price }</span>'
					tag+='</td></tr>'
				
					$('#tBody').append(tag);
				
			}
			
			
		
			
			/* 	if($('.option_select').children().val() == ''){
					alert('옵션값을 모두 선택해 주세요.')
				} 
				
				var optionList= new Array(); */
				
				
	          // alert($(this).val());
	          // alert($(this).children("option:selected").text());
		});
		
	});
	
</script>

</head>
<style>
body {
	margin-top: 50px;
}

.img-thumbnail.main {
	width: 300px;
}

.img-thumbnail.sub {
	width: 150px;
}

.left-content {
	float: left;
}

.right-content {
	margin-left: 400px;
	height: 560px;
}

span {cursor:pointer; }

.number{
	margin:100px;
}

.minus,.plus{
	width:30px;
	height:30px;
	background:#f2f2f2;
	border-radius:4px;
	border:1px solid #ddd;
    display: inline-block;
    vertical-align: middle;
    text-align: center;
}

.count_input{
	height:34px;
    width: 80px;
    text-align: center;
    font-size: 20px;
	border:1px solid #ddd;
	border-radius:4px;
    display: inline-block;
    vertical-align: middle;
}

element.style 
{ 
    width:300px !important; 
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
				<div style="margin-top: 110px;">
					<div class="left-content">
						<c:forEach items='${vo.pro_Image }' var='iList'>
							<c:choose>
								<c:when test="${iList.is_main }">
									<div>
										<img alt="상품  메인 이미지"
											src="${pageContext.request.contextPath}/assets-upload${iList.url }"
											class="img-thumbnail main">
									</div>
								</c:when>
								<c:otherwise>
									<img alt="상품  서브 이미지"
										src="${pageContext.request.contextPath}/assets-upload${iList.url }"
										class="img-thumbnail sub">
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
					<div class="right-content">

						<h3 class="card-title">상품명 : ${vo.name }</h3>
						<br />
						<h4>가격 : ${vo.price }</h4>
						<br />
						<p class="card-text">설명 : ${vo.summary }</p>
						<p>
							<c:forEach items='${vo.option }' var='option_list'>
								<h6>${option_list.name }</h6>
								<select class="form-control option_select" >
									<option value="" selected disabled >==선택하세요==</option>
									<c:forEach items="${option_list.option_ma}" var="option_ma_list">
										<option value="pro_option">${option_ma_list.value}</option>
									</c:forEach>
								</select>
								<br />
							</c:forEach>
						</p>
						
						<p class="info ">
							(최소주문수량 1개 이상<span class="displaynone"> / 최대주문수량 0개 이하</span>)
						</p>
						
						<table border="0" summary="">
							<colgroup>
								<col style="width: 150px;" />
								<col style="width: 180px;" />
								<col style="width: 110px;" />
							</colgroup>
							<thead>
								<tr>
									<th scope="col">상품명</th>
									<th scope="col">상품수</th>
									<th scope="col">가격</th>
								</tr>
							</thead>
							<tbody id="tBody">
								
							</tbody>
							
						</table>
						
						</div>
						<div class="detail">
							<p>${vo.detail }</p>
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