package com.cafe24.shop.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.shop.vo.ProductImageVo;
import com.cafe24.shop.vo.ProductVo;

@Repository
public class ProductDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean insertProduct(ProductVo vo) {
		
		int count = sqlSession.insert("admin_product.insert",vo);// 여기 가서는 상품에 대한 기본 정보들 insert
		
		return count == 1;
	}
	
	public boolean insertProductImage(List<ProductImageVo> list) {
		
		int count = 0;
		
		for(ProductImageVo vo:list) {
			sqlSession.insert("admin_image.insert",vo);
			count++;
		}
		
		return count == list.size();
	}
	
}
