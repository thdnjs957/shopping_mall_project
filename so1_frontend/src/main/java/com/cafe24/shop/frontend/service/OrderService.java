package com.cafe24.shop.frontend.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shop.frontend.dto.JSONResult;
import com.cafe24.shop.frontend.vo.BasketVo;
import com.cafe24.shop.frontend.vo.BasketVoSend;
import com.cafe24.shop.frontend.vo.ProductOptionVo;
import com.cafe24.shop.frontend.vo.UserVo;

@Service
public class OrderService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public List<Map<String, Object>> getList(BasketVo bvo) {
		String endpoint = "http://localhost:8080/so1_backend/api/basket";
		JSONResultMapList jsonResult = restTemplate.postForObject(endpoint,bvo ,JSONResultMapList.class);
		return jsonResult.getData();
	}
	
	
	public boolean addBasket(BasketVoSend param) {
		System.out.println("param은"+param);
		String endpoint = "http://localhost:8080/so1_backend/api/basket/register";
		JSONResultBoolean jsonResult = restTemplate.postForObject(endpoint,param.getBasketList(),JSONResultBoolean.class);
		return jsonResult.getData();
		
	}
	
	private static class JSONResultMapList extends JSONResult<List<Map<String,Object>>> {}
	private static class JSONResultBoolean extends JSONResult<Boolean> {}
	

	

}
