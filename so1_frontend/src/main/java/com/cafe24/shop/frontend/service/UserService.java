package com.cafe24.shop.frontend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cafe24.shop.frontend.dto.JSONResult;
import com.cafe24.shop.frontend.vo.UserVo;

@Service
public class UserService {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public UserVo get(String username) {
		
		String endpoint = "http://localhost:8080/so1_backend/api/user/getById?id="+username;
		JSONResultUser jsonResult = restTemplate.getForObject(endpoint, JSONResultUser.class);
		return jsonResult.getData();
	}
	
	public Boolean join(UserVo userVo) {
		
		String endpoint = "http://localhost:8080/so1_backend/api/user/join";
		JSONResultJoin jsonResult = restTemplate.postForObject(endpoint,userVo,JSONResultJoin.class);
		return jsonResult.getData();
		
	}
	
	private static class JSONResultUser extends JSONResult<UserVo> {}
	private static class JSONResultJoin extends JSONResult<Boolean> {}

	

}
