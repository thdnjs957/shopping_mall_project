package com.cafe24.shop.controller.api.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.OrderService;
import com.cafe24.shop.vo.OrderVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("orderAPIadminController")
@RequestMapping("/api/admin/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//관리자 주문 조회 
	@GetMapping("")
	public  ResponseEntity<JSONResult> OrderList() {
		
		List<Map<String, Object>> ol = orderService.showOrderForAdmin();
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(ol));
		
	}
	
}


