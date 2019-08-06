package com.cafe24.shop.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.shop.frontend.service.ProductService;
import com.cafe24.shop.frontend.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@GetMapping({"/list/","/list/{no}"})
	public String list(Model model) {
		List<ProductVo> productList = productService.getProductList();
		model.addAttribute("productList", productList);
		return "main/index";
	}
	
//	@ResponseBody
//	@GetMapping("/list/{no}")
//	public String list(@PathVariable("page") Integer page) {
//		productService.getProductList();
//		return "ok";
//	}
	
}
