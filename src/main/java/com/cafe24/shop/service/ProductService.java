package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<ProductVo> getSearchProductList(Map<String, Object> pMap) {
		
		//임시 데이터
		ProductVo p1 = new ProductVo(1L,"청바지","청바지입니다.",20000,"Y","<div>청바지 상품 설명입니다.</div>",100,null,1L);
		ProductVo p2 = new ProductVo(2L,"원피스","원피스입니다.",10000,"N","<div>원피스 상품 설명입니다.</div>",100,null,2L);
		
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
		ProductVo p1 = new ProductVo(1L,"청바지","청바지입니다.",20000,"Y","<div>청바지 상품 설명입니다.</div>",100,null,1L);
		
		ProductVo vo = (ProductVo) map.get("ProductVo");

		p1.setName(vo.getName());
		p1.setPrice(vo.getPrice());
		
		
		return true;
	}

	
}
