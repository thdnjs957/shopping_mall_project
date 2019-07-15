package com.cafe24.shop.controller.api.admin;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.cafe24.shop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class ProductControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void productRegister() throws Exception{

		ProductVo vo = new ProductVo(null,"청바지","청바지입니다.",20000,"Y","<div>청바지 상품 설명입니다.</div>",100,null,1L);
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/admin/product/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.data", is(true)));
	}
	
	@Test
	public void productDelete() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/{no}",1L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(1)))
		;
	}
	
	@Test
	public void productList() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data", hasSize(2)))
		.andExpect(jsonPath("$.data[0].no", is(1)))
		.andExpect(jsonPath("$.data[0].name", is("청바지")))
		.andExpect(jsonPath("$.data[0].price", is(20000)))
		.andExpect(jsonPath("$.data[1].no", is(2)))
		.andExpect(jsonPath("$.data[1].name", is("원피스")))
		.andExpect(jsonPath("$.data[1].price", is(10000)));
		;
	}
	
	@Test
	public void productListSearch() throws Exception{

		//이름과 category로 검색 가능
		ProductVo vo = new ProductVo();
		
		vo.setName("원피스");
		vo.setCategory_no(1L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data[0].no", is(2)))
		.andExpect(jsonPath("$.data[0].name", is("원피스")))
		.andExpect(jsonPath("$.data[0].price", is(10000)));
		;
	}
	
	
	@Test
	public void productUpdate() throws Exception{

		ProductVo vo = new ProductVo();
		
		vo.setName("청반바지");
		vo.setPrice(15000);
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/{no}",1L).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	
}
