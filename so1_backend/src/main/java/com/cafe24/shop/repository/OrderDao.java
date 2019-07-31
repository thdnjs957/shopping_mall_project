package com.cafe24.shop.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.OrderDetailVo;
import com.cafe24.shop.vo.OrderVo;

@Repository
public class OrderDao {
	
	@Autowired
	private SqlSession sqlSession;

	public Long insertOrder(OrderVo vo) {
		sqlSession.insert("order.insertOrder",vo);
		Long no = vo.getNo();
		return no;
	}

	public boolean insertOrderDetail(Map<String, Object> map) {
		int count = sqlSession.insert("order.insertOrderDetail",map);
		return count == 1;
	}

	public void checkStock(List<OrderDetailVo> list) {
	}

	public boolean reduceProductStock(List<OrderDetailVo> list) {

		int count = sqlSession.update("order.reduceStock",list);
		
		return count == list.size();
	}

	public List<Map<String, Object>> getList(OrderVo vo) {
		List<Map<String, Object>> map  = sqlSession.selectList("order.getList",vo);
		return map;
	}
	
}
