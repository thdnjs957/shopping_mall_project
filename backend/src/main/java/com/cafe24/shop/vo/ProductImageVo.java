package com.cafe24.shop.vo;

public class ProductImageVo {
	
	private Long no;
	private String url;
	private boolean is_main;
	private Long product_no;
	
	public ProductImageVo() {}
	
	public ProductImageVo(Long no, String url, boolean is_main, Long product_no) {
		this.no = no;
		this.url = url;
		this.is_main = is_main;
		this.product_no = product_no;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isIs_main() {
		return is_main;
	}
	public void setIs_main(boolean is_main) {
		this.is_main = is_main;
	}
	public Long getProduct_no() {
		return product_no;
	}
	public void setProduct_no(Long product_no) {
		this.product_no = product_no;
	}

	@Override
	public String toString() {
		return "ProductImageVo [no=" + no + ", url=" + url + ", is_main=" + is_main + ", product_no=" + product_no
				+ "]";
	}
	
	
}
