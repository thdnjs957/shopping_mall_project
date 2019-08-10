package com.cafe24.shop.controller.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shop.config.AppConfig;
import com.cafe24.shop.config.WebConfig;
import com.cafe24.shop.service.UserService;
import com.cafe24.shop.vo.ProductOptionVo;
import com.cafe24.shop.vo.UserVo;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void aTestCheckId() throws Exception{
		
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/user/checkId").param("id", "thdnjs9570").contentType(MediaType.APPLICATION_JSON));
		resultActions
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")))
				;
	}
	
	@Test
	public void bTestJoinUser() throws Exception{

		// 1. Normal User's Join Data
		UserVo userVo = new UserVo(null,"박건형","rjsgud9570","Athdnjs@7946","rjsgud9570@naver.com","01082938493","MALE","ROLE_USER","2019-08-10",null);
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));

		resultActions.andExpect(status().isOk())
		.andDo(print());
		
		// 2. Invalidation in Name : 
		userVo = new UserVo(null,"박","thdnjs9570","Athdnjs@7946","thdnjs9570@naver.com","01076363123","FEMALE","USER","2019-07-16",null);

		resultActions =
			mockMvc
			.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo)));

		resultActions.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result",is("fail")));
	}
	
	
	@Test
	public void cTestLoginUser() throws Exception{
		
		//1. Normal User's Join Data
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/user/login").param("id", "thdnjs9570")
			.param("password", "Athdnjs@7946")
			.contentType(MediaType.APPLICATION_JSON));
		
		resultActions
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")))
				.andExpect(jsonPath("$.data.userVo.id", is("thdnjs9570")))
				.andExpect(jsonPath("$.data.userVo.name", is("박소원")))
				;
		
		//2. Invalidation
		resultActions =
				mockMvc
				.perform(post("/api/user/login").param("id", "thdnjs957")
				.param("password", "Athdnjs@7946")
				.contentType(MediaType.APPLICATION_JSON));
			
			resultActions
				.andExpect(status().isBadRequest())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("fail")))
				;
	}
	
	@Ignore
	@Test
	public void dTestUpdateUser() throws Exception{

		UserVo vo = new UserVo();
		
		//수정할 정보 
		vo.setName("박소원");
		vo.setEmail("thdnjs9570@naver.com");
		vo.setPhone("0101234565");
		
		ResultActions resultActions = 
			mockMvc
			.perform(put("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", is(true)))
		;
	}
	
	//사용자가 옵션(색상, 사이즈)를 모두 골랐을때 ajax 요청
	@Test
	public void getProductOptionNo() throws Exception{
		
		//ajax post로 ProductOptionVo
		ProductOptionVo pov = new ProductOptionVo();
		
		pov.setName("진청/L");
		pov.setProduct_no(11L); //상품 번호
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/product/getProOptionNo").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(pov)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
//	@AfterClass //각각 말고 한번만
//	public void cleanUp() {
//		userDao.deleteAll();
//	}
	
}