package com.cafe24.shop.frontend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.shop.frontend.service.UserService;
import com.cafe24.shop.frontend.vo.ProductVo;
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
	public String join(@ModelAttribute UserVo userVo ) {
		return "user/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result, Model model) { // valid하고 만약 에러가 있으면 result에 담음
		
		userVo.setRole("ROLE_USER");
		
		if (result.hasErrors()) {
			model.addAllAttributes(result.getModel());
			return "/user/join";
		}
		
		boolean jResult = userService.join(userVo); 
		
		if(jResult)
			return "redirect:/";
		else
			return "redirect:/user/join";
	}
	
	@GetMapping("")
	public String getUserList(Model model) {
		List<UserVo> userList = userService.getUserList();
		model.addAttribute("userList",userList);
		return "admin/user_list";
	}
	
	
}
