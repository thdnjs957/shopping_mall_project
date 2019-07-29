package com.cafe24.shop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.CategoryVo;
import com.cafe24.shop.vo.ProductVo;

@Repository
public class CategoryDao {
	
	@Autowired
	private SqlSession sqlSession;

	public boolean insert(CategoryVo vo) {
		
		int count = sqlSession.insert("admin_category.insert",vo);
		
		return 1 == count;
	}
	
	public boolean update(CategoryVo vo) {
		
		int count = sqlSession.update("admin_category.update",vo);
		
		return 1 == count;
	}
	
	public boolean delete(Long no) {
		
		int count = sqlSession.update("admin_category.delete",no);
		
		return 1 == count;
	}

	public int count(Long no) {
		
		int count = sqlSession.selectOne("admin_category.count",no);
		return count;
	}

	public List<CategoryVo> getAllList() {
		
		List<CategoryVo> cList = sqlSession.selectList("admin_category.getAllList");
		return cList;
	}
	
	
}
