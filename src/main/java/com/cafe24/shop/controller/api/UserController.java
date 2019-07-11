package com.cafe24.shop.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

	@ApiOperation(value="회원가입 form")
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public JSONResult join() {
		
		String returnView = "user/loginform";
		
		return JSONResult.success(returnView);
	}
	
	@ApiOperation(value="고객(비회원) 회원가입 ")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public JSONResult join(@RequestBody @Valid UserVo userVo,BindingResult bResult) { //body에 json으로 오는거 받아내기
		
		if( bResult.hasErrors() ) {
			return JSONResult.fail("잘못된 입력값입니다.");
		}
		
		boolean result = userService.addUser(userVo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result", result);
		
		return JSONResult.success(resultMap);
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
	
	
	@ApiOperation(value="회원 로그인 form")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public JSONResult login() {
		
		String returnView = "user/loginform";
		
		return JSONResult.success(returnView);
		
	}
	
	
	@ApiOperation(value="회원 로그인")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "아이디",  dataType="string", required = true, defaultValue = ""),
		@ApiImplicitParam(name = "password", value = "비밀번호",  dataType="string", required = true, defaultValue = "")
	})
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult login(@RequestParam(value = "id", required = true, defaultValue = "") String id,
							@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("password", password);
		
		UserVo vo = userService.getByIdAndPassword(map); 
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userVo", vo);
		
		return JSONResult.success(resultMap);
		
	}
	
	
	@ApiOperation(value="회원 정보 수정 form")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public JSONResult update() {
		
		String returnView = "user/update";
		
		return JSONResult.success(returnView);
		
	}
	
	@ApiOperation(value="회원 정보 수정")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userVo", value ="회원 userVo", required=true, dataType="UserVo", defaultValue="")
	})
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public JSONResult update(HttpSession session,@RequestBody UserVo userVo) {
		
		//session에서 가져오기
//		UserVo authUser = new UserVo(1L,"박소원","thdnjs9570","1234","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-10",null);
//		
//		if(authUser == null) {
//			return JSONResult.fail("로그인이 필요합니다.");
//		}
		
		userVo.setNo(1L); //수정될 유저 번호
		
		boolean result = userService.updateUser(userVo); 
		
		return JSONResult.success(result);
		
	}
	
}



