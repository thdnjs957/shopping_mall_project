package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.ProductDao;
import com.cafe24.shop.vo.CategoryVo;
import com.cafe24.shop.vo.ImageVo;
import com.cafe24.shop.vo.OptionMasterVo;
import com.cafe24.shop.vo.OptionVo;
import com.cafe24.shop.vo.ProductOptionVo;
import com.cafe24.shop.vo.ProductVo;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public boolean addProduct(ProductVo vo) {
		
		int imageCount = 0;
		int optionCount = 0;
		
		Long no = productDao.insertProduct(vo);
		
		List<ImageVo> imageList = vo.getPro_Image();
		
		if( imageList.isEmpty() == false ) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productNo", no);
			map.put("imageList",imageList);
			imageCount = productDao.insertProductImage(map);
		}
		
		int checkSize1 = (imageList.isEmpty()) ? 0 : imageList.size();
		
		List<OptionVo> optionList = vo.getOption();
	
		
		if( optionList.isEmpty() == false ) {
			for(OptionVo ov : optionList) {
				ov.setProduct_no(no);
				Long option_no = productDao.insertOption(ov);
	
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("optionNo", option_no);
				map.put("productMasterList",ov.getOption_ma());

				productDao.insertOptionMaster(map);
				
				optionCount++;
			}
		}
		
		List<ProductOptionVo> pro_optionList = vo.getPro_option();
		
		if(pro_optionList.isEmpty() == false) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productNo", no);
			map.put("proOptionList",pro_optionList);
			optionCount = productDao.insertProOption(map);
		}
		
		int checkSize2 = (pro_optionList.isEmpty()) ? 0 : pro_optionList.size();
		
		return imageCount == checkSize1 && optionCount == checkSize2;
	}

	public List<ProductVo> getProductListforAdmin() {
		
		//product + main image
		List<ProductVo> pList = productDao.getListforAdmin();
		
		return pList;
	}
	
	public List<ProductVo> getProductList(Optional<Long> no) { //no => category_no
		
		List<ProductVo> pList = productDao.getListforUser(no);

		return pList;
	}
	
	public List<ProductVo> getProductListforUser() { 
		List<ProductVo> pList = productDao.getListforUser();
		return pList;
	}

	
	public List<ProductVo> getSearchProductList(Map<String, Object> pMap) {
		
		//임시 데이터
		ProductVo p1 = new ProductVo(null,"청바지","청바지입니다.",20000,true,"<div>청바지 상품 설명입니다.</div>",100,"2019-07-16",1L);
		ProductVo p2 = new ProductVo(null,"청바지","청바지입니다.",20000,true,"<div>청바지 상품 설명입니다.</div>",100,"2019-07-16",1L);
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		
		if(p2.getName().equals(pMap.get("name")) || p2.getCategory_no() == pMap.get("categoryNo")) {
			list.add(p2);
		}
		
		return list;
	}
	
	public boolean deleteProduct(Long no) {

		boolean result = productDao.deleteProduct(no);
				
		return result;
	}

	public boolean upDateProduct(ProductVo vo) {
		
		int imageCount = 0;
		int optionCount = 0;
		
		//productVo 수정부터
		productDao.updateProduct(vo); 
		
		Long no = vo.getNo();
		
		List<ImageVo> imageList = vo.getPro_Image(); //지금 수정해서 들어갈 데이터 저장
		
		if( imageList.isEmpty() == false ) {
			
			productDao.deleteImage(no);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productNo", no);
			map.put("imageList",imageList);
			imageCount = productDao.insertProductImage(map);
			
		}
		
		int checkSize1 = (imageList.isEmpty()) ? 0 : imageList.size();
		
		List<OptionVo> optionList = vo.getOption(); //수정해서 들어갈 옵션 데이터
	
		//옵션 일단 지움 -> 옵션 디테일도 지워짐		
		if( optionList.isEmpty() == false ) {
			
			productDao.deleteOption(no);
			
			for(OptionVo ov : optionList) {
				ov.setProduct_no(no);
				Long option_no = productDao.insertOption(ov);
	
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("optionNo", option_no);
				map.put("productMasterList",ov.getOption_ma());

				productDao.insertOptionMaster(map);
			}
		}
		
		List<ProductOptionVo> pro_optionList = vo.getPro_option();
		
		if(pro_optionList.isEmpty() == false) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("productNo", no);
			map.put("proOptionList",pro_optionList);
			optionCount = productDao.insertProOption(map);
		}
		
		int checkSize2 = (optionList.isEmpty()) ? 0 : optionList.size();
		
		return imageCount == checkSize1 && optionCount == checkSize2;
		
	}

	public ProductVo getProductDetail(Long no) {
		ProductVo vo = productDao.getProductByNo(no);
		return vo;
	}

	public ProductVo getProductDetailByUser(Map<String, Object> map) {
		ProductVo vo = productDao.getProductByMap(map);
		return vo;
	}
	
	public ProductOptionVo getProductOptionNo(ProductOptionVo vo) {

		ProductOptionVo pov = productDao.getProductOptionByName(vo);
		return pov;
		
	}
	
}
