package com.cafe24.shop.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@ApiOperation(value="회원가입 form")
	@GetMapping("/join")
	public JSONResult join() {
		
		String returnView = "user/loginform";
		
		return JSONResult.success(returnView);
	}
	
	@ApiOperation(value="고객(비회원) 회원가입 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@PostMapping("/join")
	public ResponseEntity<JSONResult> join(@RequestBody @Valid UserVo userVo,BindingResult bResult) { //body에 json으로 오는거 받아내기
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		boolean result = userService.addUser(userVo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result", result);

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultMap));
	}
	
	@ApiOperation(value="이메일 존재 여부")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", value ="이메일주소", required=true, dataType="string", defaultValue="") // 파라미터에 대한 설명해주기 
	})
	@GetMapping("/checkemail")
	public ResponseEntity<JSONResult> checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		
		boolean exist = userService.existEmail(email); //있으면 exist 임
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(exist));
		
	}
	
	@ApiOperation(value="회원 로그인 form")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@GetMapping("/login")
	public JSONResult login() {
		
		String returnView = "user/loginform";
		
		return JSONResult.success(returnView);
		
	}
	
	@ApiOperation(value="회원 로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "아이디",  dataType="string", required = true, defaultValue = ""),
		@ApiImplicitParam(name = "password", value = "비밀번호",  dataType="string", required = true, defaultValue = "")
	})
	@PostMapping("/login")
	public ResponseEntity<JSONResult> login(@RequestParam(value = "id", required = true, defaultValue = "") String id,
							@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("password", password);
		
		UserVo vo = new UserVo(id,password);
		
		//id, password에 대한 UserVo 찾아서 객체 넘겨줌
		UserVo AuthUser = userService.getUser(vo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userVo", AuthUser);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultMap));
	}
	
	@ApiOperation(value="회원 정보 수정 form")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@GetMapping("/update")
	public JSONResult update() {
		
		String returnView = "user/update";
		
		return JSONResult.success(returnView);
	}
	
	@ApiOperation(value="회원 정보 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@PutMapping("/update")
	public ResponseEntity<JSONResult> update(@RequestBody UserVo userVo) {
		
		userVo.setNo(6L); //수정될 유저 번호
		
		boolean result = userService.updateUser(userVo); 
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
		
	}
	
}



