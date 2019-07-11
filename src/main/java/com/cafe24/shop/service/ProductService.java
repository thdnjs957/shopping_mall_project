package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cafe24.shop.vo.ProductVo;

@Service
public class ProductService {
	
	public boolean addProduct(ProductVo vo) {
		vo.setCategory_no(1L);
		vo.setReg_date("2019-07-11");
	
		return true;
	}

	public List<ProductVo> getProductList() {
		
		//dao에서 getList
		
		//임시 데이터
		ProductVo p1 = new ProductVo(1L,"청바지","청바지입니다.",20000,"Y","<div>청바지 상품 설명입니다.</div>",100,null,1L);
		ProductVo p2 = new ProductVo(2L,"원피스","원피스입니다.",10000,"N","<div>원피스 상품 설명입니다.</div>",100,null,2L);
		
		List<ProductVo> pList = new ArrayList<ProductVo>();
		
		pList.add(p1);
		pList.add(p2);
		
		return pList;
	}
	
	
	
}
