package com.cafe24.shop.frontend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shop.frontend.dto.JSONResult;
import com.cafe24.shop.frontend.vo.CategoryVo;
import com.cafe24.shop.frontend.vo.ProductVo;

@Service
public class ProductService {
	
	RestTemplate restTemplate = new RestTemplate();

	public List<ProductVo> getProductList(){
		
		String endpoint = "http://localhost:8080/so1_backend/api/product/";
		
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		
		return jsonResult.getData();
	}
	
	public List<CategoryVo> getCategoryList(){
		
		String endpoint = "http://localhost:8080/so1_backend/api/admin/category/";
		
		JSONResultCategoryList jsonResult = restTemplate.getForObject(endpoint, JSONResultCategoryList.class);
		
		System.out.println(jsonResult.getData());
		
		return jsonResult.getData();
	}
	
//	public Goods getList(Long no){
//		String endpoint = "http://localhost:8888/api/address";
//		JSONResultGoods jsonResult = restTemplate.getForObject(endpoint, JSONResultGoods.class);
//		return jsonResult.getData();
//	}
	
	
	// DTO Class
//	private static class JSONResultGoods extends JSONResult<Goods> {
//	}
	
	private static class JSONResultProductList extends JSONResult<List<ProductVo>> {
	}
	
	private static class JSONResultCategoryList extends JSONResult<List<CategoryVo>> {
	}
}

