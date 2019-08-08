package com.cafe24.shop.controller.api.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.ProductService;
import com.cafe24.shop.vo.ImageVo;
import com.cafe24.shop.vo.OptionVo;
import com.cafe24.shop.vo.ProductOptionVo;
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
	@ApiOperation(value="관리자 상품 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@PostMapping("/register")
	public ResponseEntity<JSONResult> productRegister(@RequestBody @Valid ProductVo vo,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		if(vo.getPro_Image() == null) {
			vo.setPro_Image(new ArrayList<ImageVo>());
		}
		if(vo.getOption() == null) {
			vo.setOption(new ArrayList<OptionVo>());
		}
		if(vo.getPro_option() == null) {
			vo.setPro_option(new ArrayList<ProductOptionVo>());
		}
		
		boolean result = productService.addProduct(vo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	//관리자 상품 목록 조회
	@ApiOperation(value="관리자 상품 목록 조회")
	@GetMapping("")
	public ResponseEntity<JSONResult> productList() {
		
		//상품 리스트
		List<ProductVo> pList = productService.getProductListforAdmin();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(pList));
	}
	
	
	//관리자 상품 디테일 조회
	@ApiOperation(value="관리자 상품 상세 조회")
	@GetMapping("/{no}")
	public ResponseEntity<JSONResult> productDetail(@PathVariable(value="no") Long no) {
		
		//상품 디테일 조회
		ProductVo vo = productService.getProductDetail(no);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}
	
	
	//관리자 상품 검색 조회
	@ApiOperation(value="관리자 상품 검색 조회(이름, 카테고리)")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@PostMapping("")
	public ResponseEntity<JSONResult> productSearch(@RequestBody @Valid ProductVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", vo.getName());
		map.put("categoryNo",vo.getCategory_no());
		
		List<ProductVo> pList = productService.getSearchProductList(map);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(pList));
	}
		
	
	//관리자 상품 삭제
	@ApiOperation(value="관리자 상품 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> productDelete(@PathVariable(value="no") Long no) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		boolean result = productService.deleteProduct(no);
		
		if(!result) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("입력 형식이 유효하지 않습니다."));
		}
		
		map.put("result", result);
		map.put("no", no);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(map));
	}

	
	//관리자 상품 수정
	@ApiOperation(value="관리자 상품 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productVo", value ="상품 productVo", required=true, dataType="ProductVo", defaultValue="")
	})
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> productUpdate(@PathVariable(value="no") Long no,@RequestBody @Valid ProductVo vo) { 
		
		vo.setNo(no);
		
		boolean result = productService.upDateProduct(vo);
		
		if(!result) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("입력 형식이 유효하지 않습니다."));
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	
	
}



