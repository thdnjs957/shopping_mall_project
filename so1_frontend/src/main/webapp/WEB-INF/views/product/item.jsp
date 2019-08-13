<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
			var $price = $(this).parent().parent().find('.quantity_price');
			$price.text(parseInt($input.val()) * ${vo.price});
			$input.change();
			return false;
		});
		
		$(document).on('click','.plus',function(e){
			var $input = $(this).parent().find('input');
			$input.val(parseInt($input.val()) + 1);
			var $price = $(this).parent().parent().find('.quantity_price');
			$price.text(parseInt($input.val()) * ${vo.price});
			$input.change();
			return false;
		});
		
		var isFirst = true;
		
		$('.option_select').change(function() {
			
			var se = $(".option_select option:selected");
			
			var result = '';
			
			if(se.last().val() != ''){ 
				
				var a;
				
				se.each(function(index,item) {
					if(item.value == ''){
						alert('옵션값을 선택해주세요');
						return false;
					}
					else{
						result += item.text +'/';
					}
				});
				
				if(result != ''){
					
					if(isFirst){
						var tag = '(최소주문수량 1개 이상<span class="displaynone"> / 최대주문수량 0개 이하</span>)'
			            tag += '<table border="0" summary="">'
			            tag+='<colgroup>'
			            tag+='<col style="width: 150px;" /><col style="width: 180px;" /><col style="width: 110px;" />'
			            tag+='</colgroup>'		
			           	tag+='<thead><tr><th scope="col">상품명</th><th scope="col">상품수</th><th scope="col">가격</th></tr></thead>'
			           	tag+='<tbody id="tBody">'
			           	tag+='</tbody>'
			           	tag+='</table>'
			           	
			           	$('#pro_option_div').append(tag);
					}
				
					result = result.substr(0, result.length -1);
					
					var pro_no = 0;
					
					$.ajax({
					    type: "POST",
					    url : "${pageContext.servletContext.contextPath }/product/getByName",
					    data : { 
					    		  product_no: ${vo.no},
					              name: result 
					            },
					    contentType : "application/x-www-form-urlencoded; charset=utf-8",
					    dataType : "json",
					    async:false,
					    success : function(data){
					    	 //Ajax 성공시
					    	 pro_no = data.no;
					    },error : function(){
					        //Ajax 실패시
					        alert('실패했습니다');
					    }
					});
					
					var tag = '<tr class = "pro_option_tr"><td>(${vo.name})'+result+'</td>'
			            tag+='<td style="width:80px;">'
			            tag+='<span class="minus">-</span>'
			            tag+='<input class="count_input" type="text" value="1"/>'
			            tag+='<span class="plus">+</span>'		
			           	tag+='</td>'
						tag+='<td class="right"><span class="quantity_price">${vo.price }</span></td>'
						tag+='<td><input type="hidden" value="'+pro_no+'" name="'+pro_no+'" class="pro_option_no"/></td>'
						tag+='</tr>'
					
					$('#tBody').append(tag);
					
					isFirst = false;
				}
			}
		});
		
		//장바구니 ajax
		$('#basket_button').click(function() {
		
			var totVo = new Object();
			var voList = new Array();
			
			$(".pro_option_tr").each(function(index, item) {
				var vo = new Object();
				vo["pro_option_no"] = $(item).children().eq(3).find('.pro_option_no').val();
				vo["count"] = $(item).children().eq(1).find('.count_input').val();
				voList.push(vo);
			});
			
			totVo["basketList"] = voList;
			
			$.ajax({
			    type: "POST",
			    url : "${pageContext.servletContext.contextPath }/basket/register",
			    data : JSON.stringify(totVo) ,
			    dataType : "json",
			    contentType: 'application/json',
			    success : function(data){
			    	 //Ajax 성공시
			    	 var con = confirm('장바구니 등록에 성공하셨습니다. 확인하시겠습니까?');
					 if (con) {
						  window.location.href = "${pageContext.servletContext.contextPath}/basket"
					 }
					 else {
					     alert('삭제가 취소되었습니다.');
					 }
					 
			    },error : function(){
			        //Ajax 실패시
			        alert('실패했습니다');
			    }

			});
				
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
			<h1>${pov.no }</h1>
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
							
						</p>
						
						<!-- form -->
						<div id="pro_option_div" style="float:left; margin-bottom:20px;">
							
						</div>
						
						<div id ="base-button" style="float:left;"> 
							<button class="btn btn-info" id = "basket_button">장바구니 추가</button>
							<button class="btn btn-info">주문하기</button>
						</div>
						
						</div>
						<div class="detail" style="margin-top:50px;">
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