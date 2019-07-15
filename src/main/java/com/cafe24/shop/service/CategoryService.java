package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cafe24.shop.vo.CategoryVo;
import com.cafe24.shop.vo.ProductVo;

@Service
public class CategoryService {
	
	public boolean addCategory(CategoryVo vo) {
		
		vo.setNo(1L);
		
		return true;
	}

	public boolean updateCategory(Map<String, Object> map) {
		
		Long no = (Long) map.get("no");

		//no 통해서 getCategory 
		CategoryVo p1 = new CategoryVo(1L,"TOP",0);
		
		CategoryVo vo = (CategoryVo) map.get("CategoryVo");

		p1.setName(vo.getName());
		p1.setTop_category(vo.getTop_category());
		
		return true;
	}

	public boolean deleteCategory(Long no) {

		//Long no = 삭제할 카테고리 no
		//categoryDao.delete(no);
		
		return true;
	}

	
	
}
