package com.cafe24.shop.frontend.dto;

import java.util.List;

import com.cafe24.shop.frontend.vo.OrderDetailVo;

public class OrderDetailListDto {

	private List<OrderDetailVo> detailList;

	public OrderDetailListDto() {}
	
	public List<OrderDetailVo> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetailVo> detailList) {
		this.detailList = detailList;
	}

	@Override
	public String toString() {
		return "OrderDetailListDto [detailList=" + detailList + "]";
	} 
	
}
