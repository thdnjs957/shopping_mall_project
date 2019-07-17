package com.cafe24.shop.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.OptionMasterVo;
import com.cafe24.shop.vo.OptionVo;
import com.cafe24.shop.vo.ProductImageVo;
import com.cafe24.shop.vo.ProductVo;

@Repository
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Long insertProduct(ProductVo vo) {
		sqlSession.insert("admin_product.insert",vo);// 여기 가서는 상품에 대한 기본 정보들 insert
		
		//last autoincrement value
		Long no = vo.getNo();
		
		return no;
	}
	
	public boolean insertProductImage(ProductImageVo vo) {
		
		int count = sqlSession.insert("admin_image.insert",vo);
		
		return 1==count;
	}
	
	public Long insertOption(OptionVo vo) {
		
		sqlSession.insert("admin_option.insert",vo);// 여기 가서는 상품에 대한 기본 정보들 insert
		
		//last autoincrement value
		Long no = vo.getNo();
		
		return no;
	}

	public boolean insertOptionMaster(OptionMasterVo mv) {
		int count = sqlSession.insert("admin_option_ma.insert",mv);
		return 1==count;
	}
	
}
