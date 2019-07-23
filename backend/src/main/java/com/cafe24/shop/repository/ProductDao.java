package com.cafe24.shop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.CategoryVo;
import com.cafe24.shop.vo.ImageVo;
import com.cafe24.shop.vo.OptionMasterVo;
import com.cafe24.shop.vo.OptionVo;
import com.cafe24.shop.vo.ProductOptionVo;
import com.cafe24.shop.vo.ProductVo;

@Repository
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ProductVo> getList() {
		List<ProductVo> pList = sqlSession.selectList("product.getList");
		return pList;
	}
	
	public Long insertProduct(ProductVo vo) {
		sqlSession.insert("product.insert",vo);// 여기 가서는 상품에 대한 기본 정보들 insert
		
		//last autoincrement value
		Long no = vo.getNo();
		
		return no;
	}
	
	public boolean insertProductImage(ImageVo vo) {
		
		int count = sqlSession.insert("product.insert_image",vo);
		
		return 1==count;
	}
	
	public Long insertOption(OptionVo vo) {
		
		sqlSession.insert("product.insert_option",vo);// 여기 가서는 상품에 대한 기본 정보들 insert
		
		//last autoincrement value
		Long no = vo.getNo();
		
		return no;
	}

	public boolean insertOptionMaster(OptionMasterVo mv) {
		int count = sqlSession.insert("product.insert_option_ma",mv);
		return 1==count;
	}

	public boolean insertProOption(ProductOptionVo pov) {
		
		int count = sqlSession.insert("product.insert_pro_option",pov);
		return 1==count;
		
	}

	public boolean deleteProduct(Long no) {
		int count = sqlSession.delete("product.delete_product",no);
		return 1 == count;
	}

	public ProductVo getProductByNo(Long no) {
		ProductVo vo = sqlSession.selectOne("product.getByNo", no);
		return vo;
	}

	public List<OptionVo> getOptionByNo(Long no) {
		List<OptionVo> list = sqlSession.selectList("product.getOptionByNo",no);
		return list;
	}
	
	public List<OptionMasterVo> getOptionMasterByNo(Long no) {
		List<OptionMasterVo> list = sqlSession.selectList("product.getOptionMasterByNo",no);
		return list;
	}

	public List<ImageVo> getImageByNo(Long no) {
		List<ImageVo> list = sqlSession.selectList("product.getImageByNo",no);
		return list;
	}

	public List<ProductVo> getListforAdmin() {
		List<ProductVo> list = sqlSession.selectList("product.getListforAdmin");
		return list;
	}

}
