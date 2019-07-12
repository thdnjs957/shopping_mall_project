package com.cafe24.shop.controller.api.admin;

import java.util.HashMap;
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
import com.cafe24.shop.service.CategoryService;
import com.cafe24.shop.vo.CategoryVo;
import com.cafe24.shop.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("adminAPIcategoryController")
@RequestMapping("/api/admin/category")
public class CategoryController {
	
	//관리자 카테고리 등록
	//관리자 카테고리 수정
	//관리자 카테고리 삭제
	
	
	@Autowired
	CategoryService categoryService;
	
	//관리자 카테고리 등록
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 카테고리 등록")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryVo", value ="카테고리 categoryVo", required=true, dataType="categoryVo", defaultValue="")
	})
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public JSONResult productRegister(@RequestBody @Valid CategoryVo vo ,BindingResult b_result) {
		
		if(b_result.hasErrors()) {
			return JSONResult.fail("잘못된 입력 값 입니다.");
		}
		
		boolean result = categoryService.addCategory(vo);
		
		return JSONResult.success(result);
	}

	
	//관리자 카테고리 수정
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 카테고리 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="categoryVo", value ="카테고리 categoryVo", required=true, dataType="categoryVo", defaultValue="")
	})
	@RequestMapping(value = "/{no}", method = RequestMethod.PUT)
	public JSONResult categoryUpdate(@PathVariable(value="no") Long no,@RequestBody @Valid CategoryVo vo) { 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("CategoryVo", vo);
		
		boolean result = categoryService.updateCategory(map);
		
		map.put("result", result);
		map.put("no", no);
		
		return JSONResult.success(map);
	}
		
	
	//관리자 상품 삭제
	@Auth(role=Auth.Role.ADMIN)
	@ApiOperation(value="관리자 카테고리 삭제")
	@RequestMapping(value = "/{no}", method = RequestMethod.DELETE)
	public JSONResult categoryDelete(@PathVariable(value="no") Long no) {
		
		Map<String, Object> map = new HashMap<String, Object>();

		boolean result = categoryService.deleteCategory(no);
		
		map.put("result", result);
		map.put("no", no);
		
		return JSONResult.success(map);
	}

	
}
