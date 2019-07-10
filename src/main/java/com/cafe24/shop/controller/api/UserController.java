package com.cafe24.shop.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	//@Autowired
	//private UserService userService;

	@ApiOperation(value="이메일 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", value ="이메일주소", required=true, dataType="string", defaultValue="") // 파라미터에 대한 설명해주기 
	})
	@RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	public JSONResult checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		
		//boolean exist = userService.existEmail(email); //있으면 exist 임
		boolean exist = true;
		return JSONResult.success(exist);
	}
	

}
