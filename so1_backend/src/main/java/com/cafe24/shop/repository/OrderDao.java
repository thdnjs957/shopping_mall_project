package com.cafe24.shop.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.OrderDetailVo;
import com.cafe24.shop.vo.OrderVo;
import com.cafe24.shop.vo.ProductOptionVo;

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

	public ProductOptionVo checkStock(OrderDetailVo vo) {
		ProductOptionVo pvo = sqlSession.selectOne("order.checkStock",vo);
		return pvo;
	}

	public boolean reduceProductStock(List<OrderDetailVo> OrderDetailList) {
		int count = sqlSession.update("order.reduceStock",OrderDetailList);
		
		return count == OrderDetailList.size();
	}

	public List<Map<String, Object>> getList(OrderVo vo) {
		List<Map<String, Object>> map  = sqlSession.selectList("order.getList",vo);
		return map;
	}

	public List<Map<String, Object>> getListForAdmin() {
		List<Map<String, Object>> map  = sqlSession.selectList("order.getListForAdminOrderDetail");
		return map;
	}
	
}
