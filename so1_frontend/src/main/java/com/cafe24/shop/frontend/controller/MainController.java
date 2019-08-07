package com.cafe24.shop.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.shop.frontend.service.ProductService;
import com.cafe24.shop.frontend.vo.CategoryVo;
import com.cafe24.shop.frontend.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping( {"/", "/main"} )
	public String main(Model model) {
		
		List<ProductVo> productList = productService.getProductList();
		List<CategoryVo> categoryList = productService.getCategoryList();
		model.addAttribute("productList", productList);
		model.addAttribute("categoryList", categoryList);
		
		return "main/index";
	}
}
