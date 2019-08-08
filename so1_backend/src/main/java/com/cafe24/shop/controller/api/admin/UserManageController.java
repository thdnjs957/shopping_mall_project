package com.cafe24.shop.controller.api.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

@RestController("adminAPIuserManageController")
@RequestMapping("/api/admin/userManage")
public class UserManageController {

	@Autowired
	private UserService userService;
	
	//관리자 고객 조건 검색
	@ApiOperation(value="관리자 고객 조건 검색")
	@ApiImplicitParams({
         @ApiImplicitParam(name = "name", value = "이름", dataType = "string", paramType = "query", defaultValue = ""),
         @ApiImplicitParam(name = "id", value = "아이디", dataType = "string", paramType = "query", defaultValue = ""),
         @ApiImplicitParam(name = "orderInquery", value = "비회원주문번호", dataType = "string", paramType = "query", defaultValue = ""),
         @ApiImplicitParam(name = "isOrdered", value = "주문여부", dataType = "string", paramType = "query", defaultValue = ""),
	})
	@PostMapping("/searchUser")
	public JSONResult userSearch(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "orderInquery", defaultValue = "") String orderInquery,
			@RequestParam(value = "isOrdered", defaultValue = "") String isOrdered) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", name);
		map.put("id",id);
		map.put("orderInquery",orderInquery);
		map.put("isOrdered",isOrdered);
		
		//List<UserVo> uList = userService.getUserSearch(map);
		
		return JSONResult.success(null);
	}
	
	
	
	
	
}
