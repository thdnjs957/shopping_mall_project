package com.cafe24.shop.controller.api.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import com.cafe24.shop.service.CategoryService;
import com.cafe24.shop.vo.CategoryVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminAPIcategoryController")
@RequestMapping("/api/admin/category")
public class CategoryController {
	
	//관리자 카테고리 목록 
	//관리자 카테고리 등록
	//관리자 카테고리 수정
	//관리자 카테고리 삭제
	
	@Autowired
	CategoryService categoryService;
	
	//관리자 카테고리 추가
	@ApiOperation(value="관리자 카테고리 추가")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryVo", value ="카테고리 categoryVo", required=true, dataType="categoryVo", defaultValue="")
	})
	@PostMapping("")
	public  ResponseEntity<JSONResult> categoryList(@RequestBody @Valid CategoryVo vo ,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		boolean result = categoryService.addCategory(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	
	
	//관리자 카테고리 등록
	@ApiOperation(value="관리자 카테고리 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryVo", value ="카테고리 categoryVo", required=true, dataType="categoryVo", defaultValue="")
	})
	@PostMapping("/register")
	public  ResponseEntity<JSONResult> categoryRegister(@RequestBody @Valid CategoryVo vo ,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		boolean result = categoryService.addCategory(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	//관리자 카테고리 수정
	@ApiOperation(value="관리자 카테고리 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryVo", value ="카테고리 categoryVo", required=true, dataType="categoryVo", defaultValue="")
	})
	@PutMapping("/{no}")
	public ResponseEntity<JSONResult> categoryUpdate(@PathVariable(value="no") Long no,@RequestBody @Valid CategoryVo vo) { 
		
		// no 값 세팅
		vo.setNo(no);
		
		boolean result = categoryService.updateCategory(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
		
	//관리자 카테고리 삭제
	@ApiOperation(value="관리자 카테고리 삭제")
	@DeleteMapping("/{no}")
	public ResponseEntity<JSONResult> categoryDelete(@PathVariable(value="no") Long no) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		boolean result = categoryService.deleteCategory(no);
		
		
		map.put("result", result);
		map.put("no", no);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(map));
	}

	
	//관리자 카테고리 조회
	@ApiOperation(value="관리자 카테고리 목록 조회")
	@GetMapping("")
	public ResponseEntity<JSONResult> categoryList() {
		
		List<CategoryVo> cList = categoryService.showCategory();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(cList));
	}
	
}
