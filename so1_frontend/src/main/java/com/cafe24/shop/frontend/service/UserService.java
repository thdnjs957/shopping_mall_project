package com.cafe24.shop.frontend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shop.frontend.dto.Goods;
import com.cafe24.shop.frontend.dto.JSONResult;

@Service
public class UserService {
	
//	@Autowired
//	private OAuth2RestTemplate restTemplate;
	
	public String getList(){
		String endpoint = "http://localhost:8080/api/product/";
		JSONResultGoodsList jsonResult = new RestTemplate().getForObject(endpoint, JSONResultGoodsList.class);
		System.out.println( jsonResult );
		return jsonResult.getData();
	}
	
	// DTO Class
	private static class JSONResultGoods extends JSONResult<Goods> {
	}
	
	private static class JSONResultGoodsList extends JSONResult<String> {
	}
}
