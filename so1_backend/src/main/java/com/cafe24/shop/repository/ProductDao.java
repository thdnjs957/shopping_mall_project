package com.cafe24.shop.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
		sqlSession.insert("product.insert",vo);
		
		//last autoincrement value
		Long no = vo.getNo();
		
		return no;
	}
	
	public int insertProductImage(Map<String, Object> map) {
		
		int count = sqlSession.insert("product.insertImage",map);
		return count;
	}
	
	public Long insertOption(OptionVo vo) {
		
		sqlSession.insert("product.insertOption",vo);
		
		//last autoincrement value
		Long no = vo.getNo();
		
		return no;
	}

	public boolean insertOptionMaster(Map<String, Object> map) {
		int count = sqlSession.insert("product.insertOptionMa",map);
		return 1==count;
	}

	public int insertProOption(Map<String, Object> map) {
		int count = sqlSession.insert("product.insertProOption",map);
		return count;
	}

	public boolean updateProduct(ProductVo vo) {
		int count = sqlSession.update("product.updateProduct",vo);
		return 1 == count;
	}
	
	public boolean deleteProduct(Long no) {
		int count = sqlSession.delete("product.deleteProduct",no);
		return 1 == count;
	}

	public ProductVo getProductByNo(Long no) {
		ProductVo vo = sqlSession.selectOne("product.getByNo", no);
		return vo;
	}

	public ProductVo getProductByMap(Map<String, Object> map) {
		ProductVo vo = sqlSession.selectOne("product.getByMap",map);
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
	
	public List<ProductVo> getListforUser(Optional<Long> no) {
		List<ProductVo> list = sqlSession.selectList("product.getListforUser",no);
		return list;
	}
	
	public List<ProductVo> getListforUser() {
		List<ProductVo> list = sqlSession.selectList("product.getListforUser");
		return list;
	}

	
	public boolean deleteImage(Long no) {
		int count = sqlSession.delete("product.deleteImage",no);
		return 1 == count;
	}

	public boolean deleteOption(Long no) {
		int count = sqlSession.delete("product.deleteOption",no);
		return 1 == count;
	}


	public ProductOptionVo getProductOptionByName(ProductOptionVo vo) {
		ProductOptionVo pov = sqlSession.selectOne("product.getProductOptionByName",vo);
		return pov;
	}




}
