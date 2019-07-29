package com.cafe24.shop.scenario;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shop.config.AppConfig;
import com.cafe24.shop.config.WebConfig;
import com.cafe24.shop.service.UserService;
import com.cafe24.shop.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class ScenarioControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	 
	
	//회원 장바구니 시나리오 시작
	
	//1. 로그인
	
	//2. 카테고리 선택 후 상품 목록 반환 

	//3. 장바구니 담기 
	
	
	//로그인
	@Test
	public void userLogin() throws Exception{
		
		//사용자가 아이디 비번 입력해서 action에 실어서 보내면 
		UserVo vo = new UserVo();
		
		vo.setId("thdnjs9570");
		vo.setPassword("1234");
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/user/login").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)))
			.andExpect(status().isOk())
			.andDo(print());
		
	}
	

//	//카테고리 선택 후 상품 목록 보기
//	@Test
//	public void testCheckEmail() throws Exception{
//		ResultActions resultActions =
//				mockMvc
//				.perform(get("/api/user/checkemail").contentType(MediaType.APPLICATION_JSON));
//		
//		resultActions
//				.andExpect(status().isOk())
//				.andDo(print())
//				.andExpect(jsonPath("$.result", is("success")))
//				;
//	}
//	
//	
//	
//	@Test
//	public void testInsertUser() throws Exception{
//
//		UserVo vo = new UserVo();
//		
//		vo.setName("박소원");
//		vo.setId("thdnjs9570");
//		vo.setPassword("1234");
//		vo.setEmail("thdnjs9570@naver.com");
//		vo.setPhone("01076363123");
//		
//		ResultActions resultActions = 
//			mockMvc
//			.perform(post("/api/user/add").contentType(MediaType.APPLICATION_JSON)
//			 .content(new Gson().toJson(vo)))
//			.andExpect(status().isOk())
//			.andDo(print());
//		
//		String result = resultActions.andReturn().getResponse().getContentAsString();
//			
//		assertEquals(result,"\"ok\"");
//	}
	
	
}
