package com.cafe24.shop.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.UserService;
import com.cafe24.shop.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value="고객(비회원) 회원가입 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@RequestBody UserVo userVo) { //body에 json으로 오는거 받아내기
		
		UserVo newVo = userService.addUser(userVo);
		
		return "ok";
	}
	
	
	@ApiOperation(value="이메일 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", value ="이메일주소", required=true, dataType="string", defaultValue="") // 파라미터에 대한 설명해주기 
	})
	@RequestMapping(value = "/checkemail", method = RequestMethod.GET)
	public JSONResult checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		
		boolean exist = userService.existEmail(email); //있으면 exist 임
		return JSONResult.success(exist);
		
	}
	
	@ApiOperation(value="회원 로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name="UserVo", value ="고객입력데이터", required=true, dataType="UserVo", defaultValue="") 
	})
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult login(@RequestParam(value="UserVo", required=true, defaultValue="") UserVo userVo) {
		
		boolean exist = userService.getByIdAndPassword(userVo); 
		return JSONResult.success(exist);
	}
	
	
	
	
}



