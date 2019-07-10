package com.cafe24.shop.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.ProductService;
import com.cafe24.shop.vo.ProductVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("productAPIController")
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="상품 목록 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no", value ="카테고리 no", dataType="Long", defaultValue="")
	})
	@RequestMapping(value="/list/{no}", method=RequestMethod.GET)
	public JSONResult getList(@PathVariable(value="no") Long no) { 
		
		List<ProductVo> list = productService.getProductList(no);
		
		return JSONResult.success(list);
	}
	
	
	@ApiOperation(value="상품 상세 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="no1", value ="카테고리 no", dataType="Long", defaultValue=""),
		@ApiImplicitParam(name="no2", value ="상품 no", dataType="Long", defaultValue="")
	})
	@RequestMapping(value="/list/{no1}/{no2}", method=RequestMethod.GET)
	public JSONResult getList(@PathVariable(value="no1") Long no1, @PathVariable(value="no2") Long no2) { 
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("no1", 1L);
		map.put("no2", 7L);
		
		ProductVo vo = productService.getProduct(map);
		
		return JSONResult.success(vo);
	}
	
	
	
}
