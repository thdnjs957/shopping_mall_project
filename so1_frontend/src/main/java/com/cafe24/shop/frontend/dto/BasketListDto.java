package com.cafe24.shop.frontend.dto;

import java.util.List;

public class BasketListDto {

	private List<BasketDto> basketList;
	
	public BasketListDto() {
		// TODO Auto-generated constructor stub
	}

	public List<BasketDto> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<BasketDto> basketList) {
		this.basketList = basketList;
	}

	@Override
	public String toString() {
		return "BasketListDto [basketList=" + basketList + "]";
	}
	
	
}
