package com.cafe24.shop.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.BasketVo;

@Repository
public class BasketDao {
	
	@Autowired
	private SqlSession sqlSession;

	public boolean insert(BasketVo vo) {
		
		int count = sqlSession.insert("basket.insert",vo);
		
		return 1 == count;
	}

	public List<Map<String, Object>> getList(Long no) { 
		List<Map<String, Object>> map  = sqlSession.selectList("basket.getList",no);
		return map;
	}

	public boolean update(BasketVo vo) {

		int count = sqlSession.update("basket.update",vo);
		return 1 == count;
	
	}
	
	
}
