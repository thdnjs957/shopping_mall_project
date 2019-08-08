<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading">관리자 페이지 </div>
      <div class="list-group list-group-flush">
        <a href="#" class="list-group-item list-group-item-action bg-light">Dashboard</a>
        <a href="${pageContext.servletContext.contextPath }/admin/product/register" class="list-group-item list-group-item-action bg-light">상품등록</a>
        <a href="${pageContext.servletContext.contextPath }/admin/product" class="list-group-item list-group-item-action bg-light">상품조회</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">주문관리</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">카테고리관리</a>
        <a href="#" class="list-group-item list-group-item-action bg-light">사용자관리</a>
        
      </div>
    </div> 