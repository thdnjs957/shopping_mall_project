package com.cafe24.shop.controller.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shop.config.AppConfig;
import com.cafe24.shop.config.WebConfig;
import com.cafe24.shop.service.UserService;
import com.cafe24.shop.vo.UserVo;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Autowired
	private UserService userService; 
	
	
	@Test
	public void testDIUserService() {
		assertNotNull(userService);
	}
	
	@Test
	public void testCheckEmail() throws Exception{
		ResultActions resultActions =
				mockMvc
				.perform(get("/api/user/checkemail").contentType(MediaType.APPLICATION_JSON));
		
		resultActions
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.result", is("success")))
				;
		
	}
	
	
	@Test
	public void testInsertUser() throws Exception{

		UserVo vo = new UserVo();
		
		vo.setName("박소원");
		vo.setId("thdnjs9570");
		vo.setPassword("1234");
		vo.setEmail("thdnjs9570@naver.com");
		vo.setPhone("01076363123");
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/user/add").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)))
			.andExpect(status().isOk())
			.andDo(print());
		
		String result = resultActions.andReturn().getResponse().getContentAsString();
			
		assertEquals(result,"\"ok\"");
	}
	
	@Ignore
	@Test
	public void testGetUser() throws Exception{

//		Long no = null;
		
		ResultActions resultActions = 
			mockMvc
			.perform(get("/api/user/{no}").contentType(MediaType.APPLICATION_JSON));
		

		//가져온 userVo의 no 이 요청한 no 이랑 같으면 통과
		resultActions.andExpect(status().isOk())
		.andDo(print());
		//.andExpect(jsonPath("$.data.no", is(no)));
		
		
		//assertEquals(resultActions,"ok");

	}
	
	@Ignore
	@Test
	public void testUpdateUser() throws Exception{

		UserVo vo = new UserVo();
		
		vo.setName("박소원");
		vo.setId("thdnjs9570");
		vo.setPassword("1234");
		vo.setEmail("thdnjs9570@naver.com");
		vo.setPhone("01076363123");
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.name", is(vo.getName())))
		.andExpect(jsonPath("$.data.id", is(vo.getId())))
		.andExpect(jsonPath("$.data.email", is(vo.getEmail())))
		.andExpect(jsonPath("$.data.phone", is(vo.getPhone())))
		;

	}
	
	
}