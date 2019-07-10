package com.cafe24.shop.vo;


public class UserVo {
	
	private Long no;
	private String name;
	private String id;
	private String password;
	private String email;
	private String phone;
	private enum sex{ USER,ADMIN };
	private enum auth{ USER,ADMIN };
	private String join_date;
	private String wdraw_date;

	/*
	 * @NotEmpty
	 * 
	 * @Length(min=2, max=8) private String name;
	 * 
	 * @Email
	 * 
	 * @NotEmpty private String email;
	 */
	
	
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
	
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", name=" + name + ", id=" + id + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", join_date=" + join_date + ", wdraw_date=" + wdraw_date + "]";
	}
	
	
	
	
	
}
