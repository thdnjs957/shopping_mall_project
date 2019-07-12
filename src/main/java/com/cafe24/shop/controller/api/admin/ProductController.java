package com.cafe24.shop.controller.api.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/admin/product")
public class ProductController {
	
	//관리자 상품 등록
	//관리자 상품 조회
	//관리자 상품 수정
	//관리자 상품 삭제
	//관리자 상품 검색 리스트
	//관리자 상품 진열 관리

	@Autowired
	private ProductService productService;
	
	//관리자 상품 등록
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JSONResult productRegister(@RequestBody @Valid ProductVo vo ,BindingResult b_result) {
		
		if(b_result.hasErrors()) {
			return JSONResult.fail("잘못된 입력 값 입니다.");
		}
		
		boolean result = productService.addProduct(vo);
		
		return JSONResult.success(result);
	}
	
	

	//관리자 상품 목록 조회
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 목록 조회")
	@RequestMapping(value = "", method = RequestMethod.GET)
	public JSONResult productList() {
		
		//상품 리스트
		List<ProductVo> pList = productService.getProductList();
		
		return JSONResult.success(pList);
	}
	
	//관리자 상품 검색 조회
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 검색 조회(이름, 카테고리)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@RequestMapping(value = "", method = RequestMethod.POST)
	public JSONResult productSearch(@RequestBody @Valid ProductVo vo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", vo.getName());
		map.put("categoryNo",vo.getCategory_no());
		
		List<ProductVo> pList = productService.getSearchProductList(map);
		
		return JSONResult.success(pList);
	}
		
	
	
	//관리자 상품 삭제
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 삭제")
	@RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
	public JSONResult productDelete(@PathVariable(value="no") Long no) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		boolean result = productService.deleteProduct(no);
		map.put("result", result);
		map.put("no", no);
		
		return JSONResult.success(map);
	}

	
	
	//관리자 상품 수정
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 상품 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@RequestMapping(value = "/{no}", method = RequestMethod.PUT)
	public JSONResult productUpdate(@PathVariable(value="no") Long no,@RequestBody @Valid ProductVo vo) { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("ProductVo", vo);
		
		boolean result = productService.upDateProduct(map);
		
		map.put("result", result);
		map.put("no", no);
		
		return JSONResult.success(map);
	}
	
	
	
	
}



