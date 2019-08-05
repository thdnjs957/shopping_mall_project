package com.cafe24.shop.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shop.vo.AddressVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AddressControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void aTestAddressRegister() throws Exception{
		
		// 1. Normal address register Data
		AddressVo vo = new AddressVo(null,"소원홈스윗홈","경기 성남시 분당구 판교역로 235",13494,"박소원","010237364",true,9L); 
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/address/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
		
		// 2. Invalidate name NULL 
		vo = new AddressVo(null,null,"경기 성남시 분당구 판교역로 235",13494,"박소원","010237364",true,9L); 
		
		resultActions =
				mockMvc
				.perform(post("/api/address/register").contentType(MediaType.APPLICATION_JSON)
				 .content(new Gson().toJson(vo)));
			
			resultActions.andExpect(status().isBadRequest())
				.andDo(print())
				.andExpect(jsonPath("$.result",is("fail")));
			
	}
	
	
	@Test
	public void bTestAddressUpdate() throws Exception{

		AddressVo vo = new AddressVo();
		
		vo.setName("소원홈스윗2");
		vo.setAddress("경기 성남시 분당구 판교역로 2353");
		vo.setReceiver("박소원2");
		vo.setRec_phone("0103728383");
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/address/{no}",3L).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
		
	}
	
	
	@Test
	public void cTestAddressDelete() throws Exception{
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/address/{no}",3L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(3)))
		;
		
	}
	
	
	@Test
	public void dTestAddressList() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/address").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print());
	}
	
}