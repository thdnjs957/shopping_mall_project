package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.CategoryDao;
import com.cafe24.shop.vo.CategoryVo;
import com.cafe24.shop.vo.ProductVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public boolean addCategory(CategoryVo vo) {
		
		boolean result = categoryDao.insert(vo);
		
		return result;
	}

	public boolean updateCategory(CategoryVo vo) {

		boolean result = categoryDao.update(vo);
		
		return result;
	}

	public boolean deleteCategory(Long no) {
		
		//int count_top = categoryDao.count(no);
		//boolean hasBottom = count_top != 0 ? true : false;
		boolean result = categoryDao.delete(no);
		
		return result;
	}

	
	public List<CategoryVo> showCategory() {
		
		List<CategoryVo> cList = categoryDao.getAllList();
		return cList;
	}
	
	
}
