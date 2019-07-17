package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.ProductDao;
import com.cafe24.shop.vo.ProductImageVo;
import com.cafe24.shop.vo.ProductVo;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public boolean addProduct(ProductVo vo) {
		
		Long no = productDao.insertProduct(vo);
		
		List<ProductImageVo> imageList = vo.getPro_Image();
		
		int count = 0;
		for(ProductImageVo iv : imageList) {
			iv.setProduct_no(no);
			if(productDao.insertProductImage(iv)) {
				count++;
			}
			
		}
		
		return count == imageList.size();
	}

	public List<ProductVo> getProductList() {
		
		//dao에서 getList
		List<ProductVo> pList = new ArrayList<ProductVo>();
		
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

		//Long no = 삭제할 상품 no
		//productDao.delete(no);
		
		return true;
	}

	public boolean upDateProduct(Map<String, Object> map) {
		
		
		Long no = (Long) map.get("no");

		//no 통해서 getProduct 
		ProductVo p1 = new ProductVo(null,"청바지","청바지입니다.",20000,true,"<div>청바지 상품 설명입니다.</div>",100,"2019-07-16",1L);
		
		ProductVo vo = (ProductVo) map.get("ProductVo");

		p1.setName(vo.getName());
		p1.setPrice(vo.getPrice());
		
		
		return true;
	}

	
}
