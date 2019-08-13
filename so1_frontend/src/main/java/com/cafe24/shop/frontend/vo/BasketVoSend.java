package com.cafe24.shop.frontend.vo;

import java.util.List;

import javax.validation.constraints.Min;

public class BasketVoSend {

	private Long no;
	
	@Min(1)
	private int count;
	private String sessionId;
	private Long pro_option_no; 
	private Long user_no;
	private List<BasketVo> basketList;
	
	public BasketVoSend() {}

	@Override
	public String toString() {
		return "BasketVoSend [no=" + no + ", count=" + count + ", sessionId=" + sessionId + ", pro_option_no="
				+ pro_option_no + ", user_no=" + user_no + ", basketList=" + basketList + "]";
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getPro_option_no() {
		return pro_option_no;
	}

	public void setPro_option_no(Long pro_option_no) {
		this.pro_option_no = pro_option_no;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	public List<BasketVo> getBasketList() {
		return basketList;
	}

	public void setBasketList(List<BasketVo> basketList) {
		this.basketList = basketList;
	}

}
