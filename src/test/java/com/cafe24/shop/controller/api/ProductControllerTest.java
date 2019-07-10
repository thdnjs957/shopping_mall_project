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
import com.cafe24.shop.service.ProductService;
import com.cafe24.shop.service.UserService;
import com.cafe24.shop.vo.UserVo;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class ProductControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Autowired
	private ProductService productService; 
	
	
	@Test
	public void testDIUserService() {
		assertNotNull(productService);
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
	public void testGetProduct() throws Exception{
		
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/product/{no1}/{no2}").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)))
			.andExpect(status().isOk())
			.andDo(print());
		
	}
	
	
}