package com.cafe24.shop.vo;

public class OrderVo {
	
	private Long no;
	private String ju_name;
	private String ju_phone;
	private String su_name;
	private String su_address;
	private String su_phone;
	private String message;
	private int del_price;
	private int tot_price;
	private String password;
	private String status;
	private String order_date;
	private Long user_no;
	
	public OrderVo() {}
	
	public OrderVo(Long no, String ju_name, String ju_phone, String su_name, String su_address, String su_phone,
			String message, int del_price, int tot_price, String password, String status, String order_date,
			Long user_no) {
		super();
		this.no = no;
		this.ju_name = ju_name;
		this.ju_phone = ju_phone;
		this.su_name = su_name;
		this.su_address = su_address;
		this.su_phone = su_phone;
		this.message = message;
		this.del_price = del_price;
		this.tot_price = tot_price;
		this.password = password;
		this.status = status;
		this.order_date = order_date;
		this.user_no = user_no;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getJu_name() {
		return ju_name;
	}
	public void setJu_name(String ju_name) {
		this.ju_name = ju_name;
	}
	public String getJu_phone() {
		return ju_phone;
	}
	public void setJu_phone(String ju_phone) {
		this.ju_phone = ju_phone;
	}
	public String getSu_name() {
		return su_name;
	}
	public void setSu_name(String su_name) {
		this.su_name = su_name;
	}
	public String getSu_address() {
		return su_address;
	}
	public void setSu_address(String su_address) {
		this.su_address = su_address;
	}
	public String getSu_phone() {
		return su_phone;
	}
	public void setSu_phone(String su_phone) {
		this.su_phone = su_phone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getDel_price() {
		return del_price;
	}
	public void setDel_price(int del_price) {
		this.del_price = del_price;
	}
	public int getTot_price() {
		return tot_price;
	}
	public void setTot_price(int tot_price) {
		this.tot_price = tot_price;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	
	
	
}
