package com.cafe24.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.BasketDao;
import com.cafe24.shop.repository.ProductDao;
import com.cafe24.shop.vo.BasketVo;
import com.cafe24.shop.vo.ImageVo;
import com.cafe24.shop.vo.ProductOptionVo;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;
	
	@Autowired
	private ProductDao productDao;
	
	public boolean addBasket(List<BasketVo> bvoList) { 
		
		int count = 0;
		
		if(bvoList.isEmpty() == false) {
			for(BasketVo bvo:bvoList) {
				 if(basketDao.insert(bvo)) {
					count++; 
				 }
			}
		}
		
		int checkSize = (bvoList.isEmpty()) ? 0 : bvoList.size();

		return count == checkSize;
	}
	
	
	
	public List<Map<String, Object>> showBasket(Long no) {
		
		List<Map<String, Object>> map = basketDao.getList(no);
		return map;
		
	}


	public ProductOptionVo getProductOptionNo(ProductOptionVo vo) {

		ProductOptionVo pov = productDao.getProductOptionByName(vo);
		return pov;
		
	}

	public boolean updateBasket(BasketVo vo) {
		boolean result = basketDao.update(vo);
		return result;
	}


//	public boolean updateBasket(BasketVo vo) {
//		boolean result = basketDao.update(vo);
//		
//		return result;
//	}
//
//	public boolean deleteBasket(Long no) {
//		boolean result = basketDao.delete(no);
//		return result;
//	}
//
	

}
