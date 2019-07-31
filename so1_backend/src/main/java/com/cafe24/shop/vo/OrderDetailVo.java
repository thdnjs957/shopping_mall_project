package com.cafe24.shop.vo;

public class OrderDetailVo {

	private Long no;
	private int count;
	private Long order_no;
	private Long pro_option_no;
	
	public OrderDetailVo() {}
	
	public OrderDetailVo(Long no, int count, Long order_no, Long pro_option_no) {
		this.no = no;
		this.count = count;
		this.order_no = order_no;
		this.pro_option_no = pro_option_no;
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
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getPro_option_no() {
		return pro_option_no;
	}
	public void setPro_option_no(Long pro_option_no) {
		this.pro_option_no = pro_option_no;
	}
	
	
	
}
