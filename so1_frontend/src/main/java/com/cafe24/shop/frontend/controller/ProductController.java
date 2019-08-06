package com.cafe24.shop.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.shop.frontend.service.ProductService;
import com.cafe24.shop.frontend.vo.CategoryVo;
import com.cafe24.shop.frontend.vo.ProductVo;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/","/{no}"})
	public String list(@PathVariable("no") Long no, Model model) {
		
		List<ProductVo> productList = productService.getProductList(no);
		List<CategoryVo> categoryList = productService.getCategoryList();
		
		model.addAttribute("productList", productList);
		model.addAttribute("categoryList", categoryList);

		return "main/index";
	}
	
	@RequestMapping("/{no1}/{no2}")
	public String list(@PathVariable("no1") Long caNo,@PathVariable("no2") Long proNo,Model model) {
		
		List<CategoryVo> categoryList = productService.getCategoryList();
		
		ProductVo productVo = productService.getProduct(caNo,proNo);
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("vo", productVo);
		
		return "product/item";
	}
	
//	@ResponseBody
//	@GetMapping("/list/{no}")
//	public String list(@PathVariable("page") Integer page) {
//		productService.getProductList();
//		return "ok";
//	}
}
