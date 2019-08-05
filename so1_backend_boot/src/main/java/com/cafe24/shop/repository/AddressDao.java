package com.cafe24.shop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.AddressVo;

@Repository
public class AddressDao {
	
	@Autowired
	private SqlSession sqlSession;

	public boolean insert(AddressVo vo) {
		
		int count = sqlSession.insert("address.insert",vo);
		
		return 1 == count;
	}
	
	public boolean update(AddressVo vo) {
		
		int count = sqlSession.update("address.update",vo);
		
		return 1 == count;
	}
	
	public boolean delete(Long no) {
		
		int count = sqlSession.update("address.delete",no);
		
		return 1 == count;
	}

	public List<AddressVo> getList() {
		
		List<AddressVo> aList = sqlSession.selectList("address.getList");
		return aList;
	}
	
	
}
