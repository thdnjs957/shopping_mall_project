package com.cafe24.shop.frontend.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shop.frontend.dto.JSONResult;
import com.cafe24.shop.frontend.vo.BasketVo;
import com.cafe24.shop.frontend.vo.BasketVoSend;
import com.cafe24.shop.frontend.vo.OrderVo;
import com.cafe24.shop.frontend.vo.ProductOptionVo;
import com.cafe24.shop.frontend.vo.UserVo;

@Service
public class OrderService {
	
	RestTemplate restTemplate = new RestTemplate();

	
	public List<Map<String, Object>> getListAdmin() {
		String endpoint = "http://localhost:8080/so1_backend/api/admin/order";
		JSONResultOrderList jsonResult = restTemplate.getForObject(endpoint,JSONResultOrderList.class);
		return jsonResult.getData();
	}
	
	public List<Map<String, Object>> getListUser(Long userNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addOrder(OrderVo vo) {
		String endpoint = "http://localhost:8080/so1_backend/api/order/register";
		JSONResultBoolean jsonResult = restTemplate.postForObject(endpoint,vo,JSONResultBoolean.class);
		System.out.println(jsonResult.getMessage()+ jsonResult.getData());
		return jsonResult.getData();
		
	}
	
	
	
	private static class JSONResultBoolean extends JSONResult<Boolean> {}
	private static class JSONResultOrderList extends JSONResult<List<Map<String, Object>>> {}
	

	
}
