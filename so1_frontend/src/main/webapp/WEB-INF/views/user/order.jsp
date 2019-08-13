<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
	href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css"
	rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

	<div class="container">
		<div></div>
		<table class="table" style="margin: 70px 0;">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox" name="chk_info"
						value=""></th>
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
						<td></td>
						<td>${list.productName }</td>
						<td>${list.optionName }</td>
						<td>기본 배송</td>
						<td>${list.price }</td>
						<td>${list.count }</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>


		     <!-- 주문 정보 -->
             <div class="orderArea  ec-shop-ordererForm">
                 <div class="title">
                     <h4 class="-titlepack -font-ns">주문 정보</h4>
                     <p class="required">
                         <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /> 필수입력사항
                     </p>
                 </div>
                 <div class="ec-base-table typeWrite">
                     <table border="1" summary="">
                         <caption>주문 정보 입력</caption>
                         <colgroup>
                             <col style="width: 139px;" />
                             <col style="width: auto;" />
                         </colgroup>
                         <!-- 국내 쇼핑몰 -->
                         <tbody class="address_form  ">
                             <tr>
                                 <th scope="row">주문하시는 분 <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></th>
                                 <td>
                                     <input id="oname" name="oname" fw-filter="isFill" fw-label="주문자 성명" fw-msg="" class="inputTypeText" placeholder="" size="15" value="" type="text" />
                                 </td>
                             </tr>
                             <tr class="">
                                 <th scope="row">주소
                                     <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></th>
                                               <td>
                                                   <input id="ozipcode1" name="ozipcode1" fw-filter="isFill" fw-label="주문자 우편번호1" class="inputTypeText" placeholder="" value="" type="text" />
                                                   <a href="#none" id="btn_search_ozipcode" class="-btn -white">
                                                       <i class="fa fa-map-o"></i> 우편번호</a>
                                                   <br />
                                                   <input id="oaddr1" name="oaddr1" fw-label="주문자 주소1" fw-msg="" class="inputTypeText" placeholder="" size="40" readonly="1" value="" type="text" />
                                                   <span class="txtInfo">기본주소</span>
                                                   <br />
                                                   <input id="oaddr2" name="oaddr2" fw-filter="isFill" fw-label="주문자 주소2" fw-msg="" class="inputTypeText" placeholder="" size="40" value="" type="text" />
                                                   <span class="txtInfo">나머지주소</span>
                                                   <span class="grid displaynone">(선택입력가능)</span>
                                               </td>
                                           </tr>
                                           <tr class="">
                                               <th scope="row">휴대전화 <span class="displaynone"><img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></span>
                                               </th>
                                               <td>
                                                   <select id="ophone2_1" name="ophone2_[]" fw-filter="isNumber" fw-label="주문자 핸드폰번호" fw-alone="N" fw-msg="">
                                                       <option value="010">010</option>
                                                       <option value="011">011</option>
                                                       <option value="016">016</option>
                                                       <option value="017">017</option>
                                                       <option value="018">018</option>
                                                       <option value="019">019</option>
                                                   </select>-
                                                   <input id="ophone2_2" name="ophone2_[]" maxlength="4" fw-filter="isNumber" fw-label="주문자 핸드폰번호" fw-alone="N" fw-msg="" size="4" value="" type="text" />-
                                                   <input id="ophone2_3" name="ophone2_[]" maxlength="4" fw-filter="isNumber" fw-label="주문자 핸드폰번호" fw-alone="N" fw-msg="" size="4" value="" type="text" />
                                               </td>
                                           </tr>
                                       </tbody>

                                       <!-- 이메일 국내/해외 -->
                         <tbody class="email ec-orderform-emailRow">
                             <tr>
                                 <th scope="row">이메일 <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></th>
                                 <td>
                                     <input id="oemail1" name="oemail1" fw-filter="isFill" fw-label="주문자 이메일" fw-alone="N" fw-msg="" class="mailId" value="" type="text" />@
                                     <input id="oemail2" name="oemail2" fw-filter="isFill" fw-label="주문자 이메일" fw-alone="N" fw-msg="" class="mailAddress" readonly="readonly" value="" type="text" />
                                     <select id="oemail3" fw-filter="isFill" fw-label="주문자 이메일" fw-alone="N" fw-msg="">
                                         <option value="" selected="selected">- 이메일 선택 -</option>
                                         <option value="naver.com">naver.com</option>
                                         <option value="daum.net">daum.net</option>
                                         <option value="nate.com">nate.com</option>
                                         <option value="hotmail.com">hotmail.com</option>
                                         <option value="yahoo.com">yahoo.com</option>
                                         <option value="empas.com">empas.com</option>
                                         <option value="korea.com">korea.com</option>
                                         <option value="dreamwiz.com">dreamwiz.com</option>
                                         <option value="gmail.com">gmail.com</option>
                                         <option value="etc">직접입력</option>
                                     </select>

                                 </td>
                             </tr>
                         </tbody>
                         <!-- 비회원 결제 -->
                         <tbody class="noMember ">
                             <tr class="ec-orderform-NoMemberPasswdRow">
                                 <th scope="row">주문조회 비밀번호 </th>
                                 <td>
                                     <input id="order_password" name="order_password" fw-filter="isFill" fw-label="비회원결제 비밀번호" fw-msg="" size="7" maxlength="12" value="" type="password" /> (주문조회시 필요합니다. 영문 대소문자, 숫자, 또는 특수문자 중 2가지 이상 조합하여 6-16자로 입력해주세요)</td>
                             </tr>
                             <tr class="ec-orderform-NoMemberPasswdRow">
                                 <th scope="row">주문조회 비밀번호
                                     <br />확인 </th>
                                 <td>
                                     <input id="order_password_confirm" name="order_password_confirm" fw-filter="isFill&isMatch[order_password]" fw-label="비회원결제 비밀번호 확인" fw-msg="" size="7" maxlength="12" value="" type="password" />
                                 </td>
                             </tr>
                         </tbody>
                     </table>
                 </div>

                 <div class="ec-base-table typeWrite">
                     <table border="1" summary="">
                         <caption>주문 정보 입력</caption>
                         <colgroup>
                             <col style="width: 139px;" />
                             <col style="width: auto;" />
                         </colgroup>
                         <!-- 국내 쇼핑몰 -->
                         <tbody class="address_form  ">
                             <tr>
                                 <th scope="row">주문하시는 분 <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></th>
                                 <td>
                                     <input id="oname" name="oname" fw-filter="isFill" fw-label="주문자 성명" fw-msg="" class="inputTypeText" placeholder="" size="15" value="" type="text" />
                                 </td>
                             </tr>
                             <tr class="">
                                 <th scope="row">주소
                                     <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></th>
                                               <td>
                                                   <input id="ozipcode1" name="ozipcode1" fw-filter="isFill" fw-label="주문자 우편번호1" class="inputTypeText" placeholder="" value="" type="text" />
                                                   <a href="#none" id="btn_search_ozipcode" class="-btn -white">
                                                       <i class="fa fa-map-o"></i> 우편번호</a>
                                                   <br />
                                                   <input id="oaddr1" name="oaddr1" fw-label="주문자 주소1" fw-msg="" class="inputTypeText" placeholder="" size="40" readonly="1" value="" type="text" />
                                                   <span class="txtInfo">기본주소</span>
                                                   <br />
                                                   <input id="oaddr2" name="oaddr2" fw-filter="isFill" fw-label="주문자 주소2" fw-msg="" class="inputTypeText" placeholder="" size="40" value="" type="text" />
                                                   <span class="txtInfo">나머지주소</span>
                                                   <span class="grid displaynone">(선택입력가능)</span>
                                               </td>
                                           </tr>
                                           <tr class="">
                                               <th scope="row">휴대전화 <span class="displaynone"><img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></span>
                                               </th>
                                               <td>
                                                   <select id="ophone2_1" name="ophone2_[]" fw-filter="isNumber" fw-label="주문자 핸드폰번호" fw-alone="N" fw-msg="">
                                                       <option value="010">010</option>
                                                       <option value="011">011</option>
                                                       <option value="016">016</option>
                                                       <option value="017">017</option>
                                                       <option value="018">018</option>
                                                       <option value="019">019</option>
                                                   </select>-
                                                   <input id="ophone2_2" name="ophone2_[]" maxlength="4" fw-filter="isNumber" fw-label="주문자 핸드폰번호" fw-alone="N" fw-msg="" size="4" value="" type="text" />-
                                                   <input id="ophone2_3" name="ophone2_[]" maxlength="4" fw-filter="isNumber" fw-label="주문자 핸드폰번호" fw-alone="N" fw-msg="" size="4" value="" type="text" />
                                               </td>
                                           </tr>
                                       </tbody>

                                       <!-- 이메일 국내/해외 -->
                         <tbody class="email ec-orderform-emailRow">
                             <tr>
                                 <th scope="row">이메일 <img src="${pageContext.servletContext.contextPath }/assets/images/ico_required.gif" alt="필수" /></th>
                                 <td>
                                     <input id="oemail1" name="oemail1" fw-filter="isFill" fw-label="주문자 이메일" fw-alone="N" fw-msg="" class="mailId" value="" type="text" />@
                                     <input id="oemail2" name="oemail2" fw-filter="isFill" fw-label="주문자 이메일" fw-alone="N" fw-msg="" class="mailAddress" readonly="readonly" value="" type="text" />
                                     <select id="oemail3" fw-filter="isFill" fw-label="주문자 이메일" fw-alone="N" fw-msg="">
                                         <option value="" selected="selected">- 이메일 선택 -</option>
                                         <option value="naver.com">naver.com</option>
                                         <option value="daum.net">daum.net</option>
                                         <option value="nate.com">nate.com</option>
                                         <option value="hotmail.com">hotmail.com</option>
                                         <option value="yahoo.com">yahoo.com</option>
                                         <option value="empas.com">empas.com</option>
                                         <option value="korea.com">korea.com</option>
                                         <option value="dreamwiz.com">dreamwiz.com</option>
                                         <option value="gmail.com">gmail.com</option>
                                         <option value="etc">직접입력</option>
                                     </select>

                                 </td>
                             </tr>
                         </tbody>
                         <!-- 비회원 결제 -->
                         <tbody class="noMember ">
                             <tr class="ec-orderform-NoMemberPasswdRow">
                                 <th scope="row">주문조회 비밀번호 </th>
                                 <td>
                                     <input id="order_password" name="order_password" fw-filter="isFill" fw-label="비회원결제 비밀번호" fw-msg="" size="7" maxlength="12" value="" type="password" /> (주문조회시 필요합니다. 영문 대소문자, 숫자, 또는 특수문자 중 2가지 이상 조합하여 6-16자로 입력해주세요)</td>
                             </tr>
                             <tr class="ec-orderform-NoMemberPasswdRow">
                                 <th scope="row">주문조회 비밀번호
                                     <br />확인 </th>
                                 <td>
                                     <input id="order_password_confirm" name="order_password_confirm" fw-filter="isFill&isMatch[order_password]" fw-label="비회원결제 비밀번호 확인" fw-msg="" size="7" maxlength="12" value="" type="password" />
                                 </td>
                             </tr>
                         </tbody>
                     </table>
                 </div>

				<button class="btn btn-info" id="order_button"
					style="margin-bottom: 40px;">상품 주문하기</button>

			</div>
			<!-- /.container -->

			<!-- Footer -->
			<c:import url='/WEB-INF/views/includes/footer.jsp' />
			<!-- /.Footer -->
</body>
</html>