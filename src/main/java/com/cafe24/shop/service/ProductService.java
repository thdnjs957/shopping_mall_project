package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cafe24.shop.vo.ProductVo;

@Service
public class ProductService {

	public List<ProductVo> getProductList(Long no) {
		
		ProductVo first = new ProductVo(1L,"플라워 원피스","원피스입니다",40000,"Y","<HTML>상품설명</HTML>",10,no,"레드",0);
		ProductVo second = new ProductVo(2L,"체크 셔츠","셔츠입니다",20000,"Y","<HTML>상품설명</HTML>",10,no,"블루/S",0);
		
		List<ProductVo> list = new ArrayList<ProductVo>();
		list.add(first);
		list.add(second);
				
		return list;
	}

	public ProductVo getProduct(Map<String, Object> map) {
		return null;
	}

}
