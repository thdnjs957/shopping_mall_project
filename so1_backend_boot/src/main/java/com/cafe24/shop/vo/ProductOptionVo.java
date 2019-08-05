package com.cafe24.shop.vo;

public class ProductOptionVo {
	
	private Long no;
	private String name;
	private int stock;
	private boolean use_stock;
	private int plus;
	private Long product_no;
	
	public ProductOptionVo(){}

	public ProductOptionVo(Long no, String name, int stock, boolean use_stock, int plus, Long product_no) {
		super();
		this.no = no;
		this.name = name;
		this.stock = stock;
		this.use_stock = use_stock;
		this.plus = plus;
		this.product_no = product_no;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isUse_stock() {
		return use_stock;
	}

	public void setUse_stock(boolean use_stock) {
		this.use_stock = use_stock;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public Long getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Long product_no) {
		this.product_no = product_no;
	}

	
	
}
