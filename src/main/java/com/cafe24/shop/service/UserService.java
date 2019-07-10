package com.cafe24.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.shop.vo.UserVo;

@Service
public class UserService {

	public UserVo addUser(UserVo userVo) {
		
		userVo.setNo(1L);
		userVo.setJoin_date("2019-07-10 00:00:00");
		
		return userVo;
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

	public boolean getByIdAndPassword(UserVo userVo) {
		
		UserVo vo = new UserVo(1L,"박소원","thdnjs9570","1234","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-10",null);
		
		if(userVo.getId() == vo.getId() && userVo.getPassword() == vo.getPassword()) {
			return true;
		}
		
		else return false;
		
	}
	
}
