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

	public List<UserVo> getList() {
		
		UserVo v1 = new UserVo(1L,"박소원","thdnjs9570","1234","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-10",null);
		UserVo v2 = new UserVo(2L,"박건형","rjsgud","1234","rjsgud@naver.com","0104832923","MALE","USER","2019-07-11",null);
		
		List<UserVo> list = new ArrayList<UserVo>();
		
		list.add(v1);
		list.add(v2);
		
		return list;
	}

	public List<UserVo> getUserSearch(Map<String, Object> map) {
		
		return null;
	}

	
	
}
