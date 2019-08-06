package com.cafe24.shop.frontend.vo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class OptionVo {
	
	private Long no;
	
	@NotNull
	private String name;
	private Long product_no;
	
	@NotNull
	private List<OptionMasterVo> option_ma;
	
	public OptionVo() {}

	public OptionVo(Long no, String name, Long product_no, List<OptionMasterVo> option_ma) {
		this.no = no;
		this.name = name;
		this.product_no = product_no;
		this.option_ma = option_ma;
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

	public Long getProduct_no() {
		return product_no;
	}

	public void setProduct_no(Long product_no) {
		this.product_no = product_no;
	}

	public List<OptionMasterVo> getOption_ma() {
		return option_ma;
	}

	public void setOption_ma(List<OptionMasterVo> option_ma) {
		this.option_ma = option_ma;
	}

	
	
	
}
