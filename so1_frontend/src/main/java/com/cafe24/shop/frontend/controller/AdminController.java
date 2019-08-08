package com.cafe24.shop.frontend.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.shop.frontend.service.AdminService;
import com.cafe24.shop.frontend.service.ProductService;
import com.cafe24.shop.frontend.service.UserService;
import com.cafe24.shop.frontend.vo.CategoryVo;
import com.cafe24.shop.frontend.vo.ImageVo;
import com.cafe24.shop.frontend.vo.ProductVo;
import com.cafe24.shop.frontend.vo.UserVo;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	public String main() {
		return "admin/index";
	}

	@GetMapping("product/register")
	public String productRegister(Model model) {
		List<CategoryVo> categoryList = productService.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		return "admin/product_manage";
	}
	
	@GetMapping("product")
	public String productList(Model model) {
		List<ProductVo> productList = productService.getProductList();
		model.addAttribute("productList", productList);
		return "admin/product_list";
	}
	
	@PostMapping("product/register")
	public String productRegister(@ModelAttribute @Valid ProductVo productVo, BindingResult result, Model model,
			@RequestParam(value="main-image") MultipartFile mainImage,
			@RequestParam(value="sub-image1") MultipartFile subImage1,
			@RequestParam(value="sub-image2") MultipartFile subImage2)
	{
		productVo.setTot_stock(100);
		
		String main = productService.restore(mainImage);
		String sub1 = productService.restore(subImage1);
		String sub2 = productService.restore(subImage2);
		
		List<ImageVo> imageList = new ArrayList<ImageVo>();
		
		ImageVo image1 = new ImageVo();
		image1.setUrl(main);
		image1.setIs_main(true);
		
		ImageVo image2 = new ImageVo();
		image2.setUrl(sub1);
		image2.setIs_main(false);
		
		ImageVo image3 = new ImageVo();
		image3.setUrl(sub2);
		image3.setIs_main(false);
		
		imageList.add(image1);
		imageList.add(image2);
		imageList.add(image3);
		
		productVo.setPro_Image(imageList);
		
		Boolean pResult = productService.registProduct(productVo);
		
		return "redirect:/admin/product_list";
	}

	
	
	
}
