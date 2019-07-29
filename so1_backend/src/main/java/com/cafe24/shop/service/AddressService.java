package com.cafe24.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.AddressDao;
import com.cafe24.shop.vo.AddressVo;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;
	
	public boolean addAddress(AddressVo vo) {
		boolean result = addressDao.insert(vo);
		
		return result;
	}

	public boolean updateAddress(AddressVo vo) {
		boolean result = addressDao.update(vo);
		
		return result;
	}

	public boolean deleteAddress(Long no) {
		boolean result = addressDao.delete(no);
		return result;
	}

	public List<AddressVo> showAddress() {
		List<AddressVo> cList = addressDao.getList();
		return cList;
	}
	
}
