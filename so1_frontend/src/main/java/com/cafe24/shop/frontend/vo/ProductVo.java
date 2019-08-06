package com.cafe24.shop.frontend.vo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProductVo {

	private Long no;
	
	@NotNull
	@Length(min=2)
	private String name;
	
	private String summary;
	
	@NotNull
	private int price;
	
	@NotNull
	private boolean is_show;
	
	private String detail;
	
	private int tot_stock;
	private String reg_date;
	private Long category_no;
	
	private List<ImageVo> pro_Image;
	
	@Valid
	private List<OptionVo> option;
	
	private List<ProductOptionVo> pro_option;
	
	public ProductVo() {}
	
	@Override
	public String toString() {
		return "ProductVo [no=" + no + ", name=" + name + ", summary=" + summary + ", price=" + price + ", is_show="
				+ is_show + ", detail=" + detail + ", tot_stock=" + tot_stock + ", reg_date=" + reg_date
				+ ", category_no=" + category_no + ", pro_Image=" + pro_Image + ", option=" + option + ", pro_option="
				+ pro_option + "]";
	}
	
	public ProductVo(Long no, String name, String summary, int price, boolean is_show, String detail, int tot_stock,
			String reg_date, Long category_no) {
		this.no = no;
		this.name = name;
		this.summary = summary;
		this.price = price;
		this.is_show = is_show;
		this.detail = detail;
		this.tot_stock = tot_stock;
		this.reg_date = reg_date;
		this.category_no = category_no;
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

	public boolean isIs_show() {
		return is_show;
	}

	public void setIs_show(boolean is_show) {
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

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public Long getCategory_no() {
		return category_no;
	}

	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}

	public List<ImageVo> getPro_Image() {
		return pro_Image;
	}

	public void setPro_Image(List<ImageVo> pro_Image) {
		this.pro_Image = pro_Image;
	}

	public List<OptionVo> getOption() {
		return option;
	}

	public void setOption(List<OptionVo> option) {
		this.option = option;
	}

	public List<ProductOptionVo> getPro_option() {
		return pro_option;
	}

	public void setPro_option(List<ProductOptionVo> pro_option) {
		this.pro_option = pro_option;
	}

	
}
