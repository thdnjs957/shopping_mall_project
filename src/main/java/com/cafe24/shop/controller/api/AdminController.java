package com.cafe24.shop.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.security.Auth;
import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.ProductService;
import com.cafe24.shop.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminAPIController")
@RequestMapping("/api/admin")
public class AdminController {
	
	//관리자 상품 등록
	//관리자 상품 조회
	//관리자 상품 수정
	//관리자 상품 삭제
	//관리자 상품 진열 관리
	//관리자 상품 검색 리스트
	
	//관리자 옵션 등록
	//관리자 등록된 옵션 조회 
	//관리자 옵션 삭제
	//관리자 옵션 수정
	
	
	
	//관리자 카테고리 등록
	//관리자 카테고리 삭제
	//관리자 카테고리 수정
	
	//관리자 주문 목록 보기
	//관리자 주문 상세 보기
	
	//관리자 고객 목록 조회
	//관리자 주문 회원 조회
	
	
	
	@Autowired
	private ProductService productService;
	
	//관리자 상품 등록
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@RequestMapping(value = "/product/productRegister", method = RequestMethod.POST)
	public JSONResult adminProductRegister(@RequestBody @Valid ProductVo vo ,BindingResult b_result) {
		
		if(b_result.hasErrors()) {
			return JSONResult.fail("잘못된 입력 값 입니다.");
		}
		
		boolean result = productService.addProduct(vo);
		
		return JSONResult.success(result);
	}
	

	//관리자 상품 목록 조회
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 목록 조회")
	@RequestMapping(value = "/product/list", method = RequestMethod.GET)
	public JSONResult adminProductList() {
		
		//상품 리스트
		List<ProductVo> pList = productService.getProductList();
		
		return JSONResult.success(pList);
	}

}
