package com.cafe24.shop.vo;

public class ProductOptionMasterVo {
	private Long no;
	private String name;
	private String value;
	private Long option_no;
	
	public ProductOptionMasterVo() {}

	
	public ProductOptionMasterVo(Long no, String name, String value, Long option_no) {
		super();
		this.no = no;
		this.name = name;
		this.value = value;
		this.option_no = option_no;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getOption_no() {
		return option_no;
	}

	public void setOption_no(Long option_no) {
		this.option_no = option_no;
	}

	@Override
	public String toString() {
		return "OptionMasterVo [no=" + no + ", name=" + name + ", value=" + value + ", option_no=" + option_no + "]";
	}
	
	
}
