package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.repository.UserDao;
import com.cafe24.shop.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean addUser(UserVo userVo) {
		
		return userDao.insert(userVo);
	}

	public boolean existId(String id) {
		
		UserVo userVo = userDao.get(id);
		return userVo != null;
	}
	
	public UserVo getUserById(String id) {
		UserVo userVo = userDao.get(id);
		return userVo;
	}

	//Auth login 
	public UserVo getUser(UserVo vo) {
		
		return userDao.get(vo.getId(), vo.getPassword());
	}

	public boolean updateUser(UserVo userVo) {
		
		return userDao.update(userVo);
	}


	public List<UserVo> getUserList() {
		List<UserVo> list = userDao.getList();
		return list;
	}

	
	
}
