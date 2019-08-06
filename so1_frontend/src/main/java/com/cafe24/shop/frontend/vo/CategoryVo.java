package com.cafe24.shop.frontend.vo;

import javax.validation.constraints.NotNull;

public class CategoryVo {
	
	private Long no;

	@NotNull
	private String name;
	private int top_category;
	
	public CategoryVo() {}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + ", top_category=" + top_category + "]";
	}
	
	public CategoryVo(Long no, String name, int top_category) {
		this.no = no;
		this.name = name;
		this.top_category = top_category;
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

	public int getTop_category() {
		return top_category;
	}

	public void setTop_category(int top_category) {
		this.top_category = top_category;
	}


	
	
	
}
