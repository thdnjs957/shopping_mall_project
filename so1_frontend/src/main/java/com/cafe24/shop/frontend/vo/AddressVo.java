package com.cafe24.shop.frontend.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AddressVo {
	
	private Long no;
	
	@NotNull
	@Length(min=2, max=8)
	private String name;
	
	@NotNull
	private String address;
	
	@NotNull
	private int zip_code;
	
	@NotNull
	private String receiver;
	
	@NotNull
	private String rec_phone;
	
	private boolean isRep;
	private Long user_no;

	public AddressVo(){}

	public AddressVo(Long no, String name, String address, int zip_code, String receiver, String rec_phone,
			boolean isRep, Long user_no) {
		this.no = no;
		this.name = name;
		this.address = address;
		this.zip_code = zip_code;
		this.receiver = receiver;
		this.rec_phone = rec_phone;
		this.isRep = isRep;
		this.user_no = user_no;
	}




	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRec_phone() {
		return rec_phone;
	}

	public void setRec_phone(String rec_phone) {
		this.rec_phone = rec_phone;
	}

	public boolean isRep() {
		return isRep;
	}

	public void setRep(boolean isRep) {
		this.isRep = isRep;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	

	
	
}
