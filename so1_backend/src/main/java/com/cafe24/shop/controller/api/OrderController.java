package com.cafe24.shop.controller.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.shop.dto.JSONResult;
import com.cafe24.shop.service.OrderService;
import com.cafe24.shop.vo.OrderVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController("orderAPIController")
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	//사용자 주문
	@ApiOperation(value="사용자 주문")
	@ApiImplicitParams({
		@ApiImplicitParam(name="OrderVo", value ="회원 OrderVo", required=true, dataType="OrderVo", defaultValue="")
	})
	@PostMapping("/register")
	public  ResponseEntity<JSONResult> orderRegister(@RequestBody @Valid OrderVo vo ,BindingResult bResult) {
		
		if(bResult.hasErrors()) {
			List<ObjectError> list = bResult.getAllErrors();
			for(ObjectError error: list) {
				return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		
		//재고 있는지 확인 
		if(orderService.UnAvailableCauseForOrder(vo) == 1) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("재고가 없는 상품입니다."));
		}
		if(orderService.UnAvailableCauseForOrder(vo) == 2) {
			return ResponseEntity.status(HttpStatus.OK).body(JSONResult.fail("재고보다 더 많은 수량을 선택하셨습니다."));
		}
		
		//주문 insert
		boolean result = orderService.addOrder(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}
	
	//사용자 주문 조회 
	@ApiOperation(value="사용자 주문 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="BasketVo", value ="장바구니 BasketVo", required=true, dataType="BasketVo", defaultValue="")
	})
	@GetMapping("")
	public  ResponseEntity<JSONResult> OrderList(@RequestBody OrderVo vo) {
		
		List<Map<String, Object>> ol = orderService.showOrder(vo);
		
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(ol));
		
	}
		
}