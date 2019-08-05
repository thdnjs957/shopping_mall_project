package com.cafe24.shop.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.cafe24.shop.frontend.dto.JSONResult;

@Service
public class ProductService {
	
	@Autowired
	private OAuth2RestTemplate restTemplate;

	public String getList(){
		String endpoint = "http://localhost:8080/so1_backend/api/product/";
		JSONResultProductList jsonResult = restTemplate.getForObject(endpoint, JSONResultProductList.class);
		System.out.println( "jsonResult"+ jsonResult );
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
	
	private static class JSONResultProductList extends JSONResult<String> {
	}
}

