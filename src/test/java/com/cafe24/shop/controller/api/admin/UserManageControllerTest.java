package com.cafe24.shop.controller.api.admin;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
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

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shop.config.AppConfig;
import com.cafe24.shop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserManageControllerTest {
private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void userManageList() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/userManage").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", hasSize(2)))
		.andExpect(jsonPath("$.data[0].no", is(1)))
		.andExpect(jsonPath("$.data[0].name", is("박소원")))
		.andExpect(jsonPath("$.data[0].id", is("thdnjs9570")))
		.andExpect(jsonPath("$.data[1].no", is(2)))
		.andExpect(jsonPath("$.data[1].name", is("박건형")))
		.andExpect(jsonPath("$.data[1].id", is("rjsgud")));
		;
	}
	
	@Test
	public void userSearchList() throws Exception{
		
		//회원 검색 조회
		//검색 조건: 이름,아이디,주문 여부 
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/userManage").param("name", "박소원")
						.param("id", "thdnjs9570").param("isOrdered","Y").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data[0].no", is(1)))
		.andExpect(jsonPath("$.data[0].name", is("박소원")))
		.andExpect(jsonPath("$.data[0].id", is("thdnjs9570")));
		;
	}
	
	@Test
	public void nonUserSearchList() throws Exception{
		
		//비회원 검색 조회 
		//검색 조건: 주문번호,주문 여부 
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/searchUser").param("orderInquery", "201907120001")
						.param("isOrdered","Y").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data[0].no", is(2)))
		.andExpect(jsonPath("$.data[0].name", is("원피스")))
		;
	}
	
}
