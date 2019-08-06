package com.cafe24.shop.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.shop.frontend.service.UserService;
import com.cafe24.shop.frontend.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/join")
	public String join() {
		return "user/join";
	}
	
//	@PostMapping("/login")
//	public String login( @ModelAttribute UserVo voModel model) {
//
//		return "redirect:/user/login_result";
//	}
//	
	 

}
