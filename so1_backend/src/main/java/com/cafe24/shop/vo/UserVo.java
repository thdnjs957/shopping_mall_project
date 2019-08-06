package com.cafe24.shop.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.shop.validator.constraints.ValidPassword;

public class UserVo {
	
	private Long no;
	
	@NotEmpty
	@Length(min=2, max=6)
	private String name;
	
	@NotEmpty
	@Length(min=2, max=10)
	private String id;
	
	@ValidPassword
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	private String phone;
	
	
	private String gender;
	
	private String role;
	
	private String join_date;
	private String wdraw_date;
	
	public UserVo() {}
	
	public UserVo(String name,String password) {
		this.name = name;
		this.password = password;
	}

	public UserVo(Long no, String name, String id, String password, String email, String phone, String gender,
			String role, String join_date, String wdraw_date) {
		this.no = no;
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.role = role;
		this.join_date = join_date;
		this.wdraw_date = wdraw_date;
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


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getJoin_date() {
		return join_date;
	}


	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}


	public String getWdraw_date() {
		return wdraw_date;
	}


	public void setWdraw_date(String wdraw_date) {
		this.wdraw_date = wdraw_date;
	}

	
	
	
}
