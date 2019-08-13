package com.cafe24.shop.frontend.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shop.frontend.security.SecurityUser;
import com.cafe24.shop.frontend.service.BasketService;
import com.cafe24.shop.frontend.vo.BasketVo;
import com.cafe24.shop.frontend.vo.BasketVoSend;

@Controller
@RequestMapping("/basket")
public class BasketController {
	
	@Autowired
	private BasketService basketService;

	//장바구니 페이지
	@ResponseBody
	@PostMapping("/register")
	public boolean join(@RequestBody BasketVoSend param, Model model,@AuthenticationPrincipal SecurityUser user) { 		
	
		Long userNo = user.getNo();
		
		for(BasketVo str : param.getBasketList()) {
			str.setUser_no(userNo);
		}

		boolean result = basketService.addBasket(param);
		
		return result;
	}
	
	@GetMapping("")
	public String getBasketList(Model model,@AuthenticationPrincipal SecurityUser user) {
		
		Long userNo = user.getNo();
		
		BasketVo bv = new BasketVo();
		bv.setUser_no(userNo);
		
		List<Map<String, Object>> basketList = basketService.getList(bv);
		model.addAttribute("basketList",basketList);
		return "user/basket";
	}
	
	
}
