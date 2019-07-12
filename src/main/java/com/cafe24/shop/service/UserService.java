package com.cafe24.shop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cafe24.shop.vo.UserVo;

@Service
public class UserService {

	public boolean addUser(UserVo userVo) {
		
		userVo.setNo(1L);
		userVo.setJoin_date("2019-07-10 00:00:00");
		
		return true;
	}

	public boolean existEmail(String email) {
		
		UserVo vo = new UserVo(1L,"박소원","thdnjs9570","1234","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-10",null);
		
		UserVo userVo = vo;
		return userVo != null;
	}
	
	
	public UserVo getUser(long no) {
		
		UserVo vo = new UserVo(1L,"박소원","thdnjs9570","1234","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-10",null);
		
		UserVo resultVo = null;
		
		if(vo.getNo() == no) {
			resultVo = vo;
		}
		
		return resultVo;
	}

	public UserVo getByIdAndPassword(Map<String, Object> map) {
		
		UserVo vo = new UserVo(1L,"박소원","thdnjs9570","1234","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-10",null);
		
		return vo;
		
	}

	public boolean updateUser(UserVo userVo) {
		
		userVo.setName("박소원");
		userVo.setEmail("thdnjs9570@naver.com");
		userVo.setPhone("01011111111");
		
		return true;
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
