package com.cafe24.shop.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.BasketDao;
import com.cafe24.shop.vo.BasketVo;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;
	
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


	public boolean updateBasket(BasketVo vo) {
		boolean result = basketDao.update(vo);
		return result;
	}



	public boolean deleteBasket(Long no) {
		boolean result = basketDao.delete(no);
		return result;
	}



	public boolean checkBasket(Long no) {

		List<BasketVo> list = basketDao.check(no);
		
		return list.size() > 0;
		
	}

	

}
