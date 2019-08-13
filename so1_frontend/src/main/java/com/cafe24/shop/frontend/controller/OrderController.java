package com.cafe24.shop.frontend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shop.frontend.dto.BasketDto;
import com.cafe24.shop.frontend.dto.BasketListDto;
import com.cafe24.shop.frontend.dto.OrderDetailListDto;
import com.cafe24.shop.frontend.security.SecurityUser;
import com.cafe24.shop.frontend.service.BasketService;
import com.cafe24.shop.frontend.service.OrderService;
import com.cafe24.shop.frontend.service.UserService;
import com.cafe24.shop.frontend.vo.BasketVo;
import com.cafe24.shop.frontend.vo.BasketVoSend;
import com.cafe24.shop.frontend.vo.OrderVo;
import com.cafe24.shop.frontend.vo.UserVo;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/info")
	public String orderInfo(@ModelAttribute BasketListDto basketList, Model model,@AuthenticationPrincipal SecurityUser user) { 		

		Long userNo = user.getNo();
		
		System.out.println(basketList);
		List<BasketDto> dto = basketList.getBasketList();
		model.addAttribute("basketList",dto);
		
		return "user/order";
	}
	
	@PostMapping("")
	public String addOrder(@ModelAttribute OrderVo orderVo,@ModelAttribute OrderDetailListDto list, Model model,@AuthenticationPrincipal SecurityUser user) { 		

		Long userNo = user.getNo();
		
		orderVo.setUser_no(userNo);
		orderVo.setStatus("주문완료");
		orderVo.setDel_price(2500);
		orderVo.setOrderDetailList(list.getDetailList());
		
		boolean result = orderService.addOrder(orderVo);
		
		return "user/order_success";
	}
	
	
	
	@GetMapping("")
	public String getOrderListByUser(Model model,@AuthenticationPrincipal SecurityUser user) {
		
		Long userNo = user.getNo();
		
		List<Map<String, Object>> orderList = orderService.getListUser(userNo);
		model.addAttribute("orderList",orderList);
		return "user/order";
		
	}
	
	
}
