package com.cafe24.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.OrderDao;
import com.cafe24.shop.vo.OrderDetailVo;
import com.cafe24.shop.vo.OrderVo;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;
	
	public boolean addOrder(OrderVo vo) {

		Long orderNo = orderDao.insertOrder(vo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("orderNo", orderNo);
		map.put("orderDetailList",vo.getOrderDetailList());
		
		boolean result = orderDao.insertOrderDetail(map);

		//재고 감소 
		boolean result2 = orderDao.reduceProductStock(vo.getOrderDetailList());
		
		return result && result2;
		
	}

	public boolean checkProductStock(OrderVo vo) {
		List<OrderDetailVo> list = vo.getOrderDetailList();
		orderDao.checkStock(list);
		return true;
	}

	public List<Map<String, Object>> showOrder(OrderVo vo) {
		
		List<Map<String, Object>> map = orderDao.getList(vo);
		return map;
	}

	
	
}
