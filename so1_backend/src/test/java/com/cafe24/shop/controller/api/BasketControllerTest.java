package com.cafe24.shop.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
import com.cafe24.shop.vo.AddressVo;
import com.cafe24.shop.vo.BasketVo;
import com.cafe24.shop.vo.ProductOptionVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasketControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void aTestBasketRegister() throws Exception{
		
		// 회원 Normal basket register Data
		List<BasketVo> bvList = new ArrayList<BasketVo>();
		
		BasketVo bv = new BasketVo();
		
		bv.setUser_no(9L);
		bv.setPro_option_no(50L);
		bv.setCount(2);
		
		BasketVo bv2 = new BasketVo();
		
		bv2.setUser_no(9L);
		bv2.setPro_option_no(51L);
		bv2.setCount(5);
		
		bvList.add(bv);
		bvList.add(bv2);
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/basket/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(bvList)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
		
	}
	
	
	@Test
	public void cTestBasketList() throws Exception{

		ResultActions resultActions =
				mockMvc
				.perform(get("/api/basket").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print());
	}
	
	
	@Test
	public void dTestBasketUpdate() throws Exception{
		
		//1. Normal update basket
		//변경 버튼 -> 장바구니 no 값  + 변경할 수량값
		BasketVo vo = new BasketVo();
		
		vo.setNo(12L);
		vo.setCount(1);
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/basket").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
		
		//2. Bad Request update basket 0 이하 숫자 삽입
		vo = new BasketVo();
		
		vo.setNo(12L);
		vo.setCount(0);
		
		resultActions = 
				mockMvc
				.perform(put("/api/basket").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isBadRequest())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("fail")))
		;
		
	}
	
	@Test
	public void eTestBasketDelete() throws Exception{
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/basket/{no}",3L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(3)))
		;
		
	}
	
}