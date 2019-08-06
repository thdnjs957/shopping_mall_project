package com.cafe24.shop.frontend.vo;

import javax.validation.constraints.NotNull;

public class OptionMasterVo {

	private Long no;
	@NotNull
	private String value;
	private Long option_no;
	
	public OptionMasterVo() {}

	public OptionMasterVo(Long no, String value, Long option_no) {
		this.no = no;
		this.value = value;
		this.option_no = option_no;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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
	
}
