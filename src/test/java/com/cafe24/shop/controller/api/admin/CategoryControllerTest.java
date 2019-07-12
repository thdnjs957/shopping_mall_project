package com.cafe24.shop.controller.api.admin;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.cafe24.shop.vo.CategoryVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class CategoryControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void categoryRegister() throws Exception{

		CategoryVo vo = new CategoryVo(null,"TOP",1); 
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/admin/category/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.data", is(true)));
	}
	
	
	@Test
	public void categoryUpdate() throws Exception{

		CategoryVo vo = new CategoryVo();
		
		vo.setName("TOP2");
		vo.setTop_category(1);
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/category/{no}",1L).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	@Test
	public void categoryDelete() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/{no}",1L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(1)))
		;
	}
	
}
