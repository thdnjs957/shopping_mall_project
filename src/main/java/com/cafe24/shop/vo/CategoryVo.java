package com.cafe24.shop.vo;

public class CategoryVo {
	private Long no;
	private int count;
	private int top_category;
	
	public CategoryVo() {}
	
	public CategoryVo(Long no, int count, int top_category) {
		super();
		this.no = no;
		this.count = count;
		this.top_category = top_category;
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
	public int getTop_category() {
		return top_category;
	}
	public void setTop_category(int top_category) {
		this.top_category = top_category;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", count=" + count + ", top_category=" + top_category + "]";
	}
	
	
	
}
