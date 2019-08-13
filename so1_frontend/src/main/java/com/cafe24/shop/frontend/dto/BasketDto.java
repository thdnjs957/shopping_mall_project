package com.cafe24.shop.frontend.dto;

public class BasketDto {

	private Long pro_option_no;
	private int price;
	private int count;
	private String optionName;
	private Long product_no;
	private String productName;
	private Long user_no;
	
	public BasketDto() {
		// TODO Auto-generated constructor stub
	}

	public BasketDto(Long pro_option_no, int price, int count, String optionName, Long product_no, String productName,
			Long user_no) {
		super();
		this.pro_option_no = pro_option_no;
		this.price = price;
		this.count = count;
		this.optionName = optionName;
		this.product_no = product_no;
		this.productName = productName;
		this.user_no = user_no;
	}

	public Long getPro_option_no() {
		return pro_option_no;
	}

	public void setPro_option_no(Long pro_option_no) {
		this.pro_option_no = pro_option_no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Long getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Long product_no) {
		this.product_no = product_no;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	@Override
	public String toString() {
		return "BasketDto [pro_option_no=" + pro_option_no + ", price=" + price + ", count=" + count + ", optionName="
				+ optionName + ", product_no=" + product_no + ", productName=" + productName + ", user_no=" + user_no
				+ "]";
	}

	
}
