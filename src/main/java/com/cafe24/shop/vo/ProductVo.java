package com.cafe24.shop.vo;

public class ProductVo {

	private Long no;
	private String name;
	private String summary;
	private int price;
	private String is_show;
	private String detail;
	private int tot_stock;
	private Long category_no;
	
	private String pro_name;
	private int plus;
	
	
	public ProductVo() {}
	
	public ProductVo(Long no, String name, String summary, int price, String is_show, String detail, int tot_stock,
			Long category_no, String pro_name, int plus) {
		super();
		this.no = no;
		this.name = name;
		this.summary = summary;
		this.price = price;
		this.is_show = is_show;
		this.detail = detail;
		this.tot_stock = tot_stock;
		this.category_no = category_no;
		this.pro_name = pro_name;
		this.plus = plus;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIs_show() {
		return is_show;
	}
	public void setIs_show(String is_show) {
		this.is_show = is_show;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getTot_stock() {
		return tot_stock;
	}
	public void setTot_stock(int tot_stock) {
		this.tot_stock = tot_stock;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPlus() {
		return plus;
	}
	public void setPlus(int plus) {
		this.plus = plus;
	}
	
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", name=" + name + ", summary=" + summary + ", price=" + price + ", is_show="
				+ is_show + ", detail=" + detail + ", tot_stock=" + tot_stock + ", category_no=" + category_no
				+ ", pro_name=" + pro_name + ", plus=" + plus + "]";
	}

	
}
