package com.cafe24.shop.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.ProductService;
import com.cafe24.shop.vo.ProductVo;

import io.swagger.annotations.ApiOperation;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//사용자 상품 리스트 조회 + 카테고리 
	@ApiOperation(value="사용자 상품 목록 조회")
	@GetMapping("/{no}") //카테고리 no
	public ResponseEntity<JSONResult> productList(@PathVariable(value="no") Long no) {
		
		//상품 리스트
		List<ProductVo> pList = productService.getProductList(no);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(pList));
	}
	
	//사용자 상품 리스트 조회 
	@ApiOperation(value="사용자 상품 목록 조회")
	@GetMapping("") //카테고리 no
	public ResponseEntity<JSONResult> productList() {
		
		//상품 리스트
		List<ProductVo> pList = productService.getProductListforUser();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(pList));
	}
	
	//사용자 상품 상세 리스트 조회 
	@ApiOperation(value="사용자 상품 상세 조회")
	@GetMapping("/{no1}/{no2}") //카테고리 + 상품 번호
	public ResponseEntity<JSONResult> productDetail(@PathVariable(value="no1") Long no1,@PathVariable(value="no2") Long no2) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("category_no", no1);
		map.put("product_no", no2);
		
		//상품 디테일 조회
		ProductVo vo = productService.getProductDetailByUser(map);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	
	
}