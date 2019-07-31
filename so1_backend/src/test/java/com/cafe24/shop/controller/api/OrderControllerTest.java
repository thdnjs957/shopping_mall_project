package com.cafe24.shop.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shop.config.AppConfig;
import com.cafe24.shop.vo.OrderDetailVo;
import com.cafe24.shop.vo.OrderVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void aTestOrderRegister() throws Exception{
		
		//회원 주문
		OrderVo vo = new OrderVo(null,"박소원","01076363123","박건형","경기도 고양시 덕양구","01011112222","경비실에 맡겨주세요",3000,50000,null,null,"입금전",null,9L,null); 

		List<OrderDetailVo> orderDetaiList = new ArrayList<OrderDetailVo>();
		
		OrderDetailVo dvo = new OrderDetailVo();
		dvo.setPro_option_no(1L);
		dvo.setCount(2);
		
		OrderDetailVo dvo2 = new OrderDetailVo();
		dvo2.setPro_option_no(2L);
		dvo2.setCount(1);
		
		orderDetaiList.add(dvo);
		orderDetaiList.add(dvo2);
		
		vo.setOrderDetailList(orderDetaiList);
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/order/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	@Test
	public void aTestOrderRegister2() throws Exception{
		
		//회원 재고 없는 상품 주문
		OrderVo vo = new OrderVo(null,"박소원","01076363123","박건형","경기도 고양시 덕양구","01011112222","경비실에 맡겨주세요",3000,50000,null,null,"입금전",null,9L,null); 

		List<OrderDetailVo> orderDetaiList = new ArrayList<OrderDetailVo>();
		
		OrderDetailVo dvo = new OrderDetailVo();
		dvo.setPro_option_no(4L);
		dvo.setCount(2);
		
		OrderDetailVo dvo2 = new OrderDetailVo();
		dvo2.setPro_option_no(2L);
		dvo2.setCount(1);
		
		orderDetaiList.add(dvo);
		orderDetaiList.add(dvo2);
		
		vo.setOrderDetailList(orderDetaiList);
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/order/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isBadRequest())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("fail")));
	}
	
	@Test
	public void bTestNonUserOrderRegister() throws Exception{
		
		//비회원 주문
		OrderVo vo = new OrderVo(null,"박소원","01076363123","박건형","경기도 고양시 덕양구","01011112222","경비실에 맡겨주세요",3000,50000,null,"thdnjs2","입금전",null,null,null); 

		List<OrderDetailVo> orderDetaiList = new ArrayList<OrderDetailVo>();
		
		OrderDetailVo dvo = new OrderDetailVo();
		dvo.setPro_option_no(1L);
		dvo.setCount(2);
		
		OrderDetailVo dvo2 = new OrderDetailVo();
		dvo2.setPro_option_no(2L);
		dvo2.setCount(1);
		
		orderDetaiList.add(dvo);
		orderDetaiList.add(dvo2);
		
		vo.setOrderDetailList(orderDetaiList);
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/order/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	//회원 주문 조회
	@Test
	public void cTestOrderList() throws Exception{
		
		OrderVo ov = new OrderVo();
		ov.setUser_no(9L);
		
		ResultActions resultActions =
			mockMvc
			.perform(get("/api/order").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(ov)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	//비회원 주문 조회
	@Test
	public void dTestNonMemberOrderList() throws Exception{
		
		OrderVo ov = new OrderVo();
		ov.setJu_number("2019073000006");
		ov.setPassword("thdnjs2");
		
		ResultActions resultActions =
			mockMvc
			.perform(get("/api/order").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(ov)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
	}
	
	
}