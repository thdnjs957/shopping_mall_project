package com.cafe24.shop.vo;

import javax.validation.constraints.Min;

public class BasketVo {

	private Long no;
	
	@Min(1)
	private int count;
	private String sessionId;
	private Long pro_option_no; 
	private Long user_no;
	
	public BasketVo() {}

	public BasketVo(Long no, int count, String sessionId, Long pro_option_no, Long user_no) {
		this.no = no;
		this.count = count;
		this.sessionId = sessionId;
		this.pro_option_no = pro_option_no;
		this.user_no = user_no;
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
	
}
