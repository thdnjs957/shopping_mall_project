package com.cafe24.shop.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shop.frontend.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@GetMapping("/list")
	public String list() {
		productService.getList();
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/list/{no}")
	public String list(@PathVariable("page") Integer page) {
		productService.getList();
		return "ok";
	}
	
}
