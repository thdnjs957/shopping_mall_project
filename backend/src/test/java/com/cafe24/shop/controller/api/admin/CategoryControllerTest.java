package com.cafe24.shop.controller.api.admin;

import static org.hamcrest.Matchers.hasSize;
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
import com.cafe24.shop.vo.CategoryVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
@TransactionConfiguration(defaultRollback = true)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Ignore
	@Test
	public void aTestCategoryRegister() throws Exception{
		
		// 1. Normal cateogory register Data
		CategoryVo vo = new CategoryVo(null,"TOP",1); 
		
		ResultActions resultActions =
			mockMvc
			.perform(post("/api/admin/category/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.result", is("success")));
		
		// 2. Invalidate name NULL 
		vo = new CategoryVo(null,null,1);  
		
		resultActions =
				mockMvc
				.perform(post("/api/admin/category/register").contentType(MediaType.APPLICATION_JSON)
				 .content(new Gson().toJson(vo)));
			
			resultActions.andExpect(status().isBadRequest())
				.andDo(print())
				.andExpect(jsonPath("$.result",is("fail")));
	}
	
	@Ignore
	@Test
	public void bTestCategoryUpdate() throws Exception{

		CategoryVo vo = new CategoryVo();
		
		vo.setName("BOTTOM");
		//최상위라 top_category가 NULL
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/category/{no}",1L).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
		
	}
	
	@Ignore
	@Test
	public void cTestCategoryDelete() throws Exception{
		
		// 1. 하위 카테고리가 없는 경우 
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/{no}",4L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(4)))
		;
		
		//상위 카테고리 지우면 하위 카테고리도 다 지워지게 메시지: (지우려는 카테고리이름)을 삭제하시면, 하위 분류도 함께 삭제 됩니다. 삭제하시겠습니까? front에서 li 체크해서
		// 2. 하위 카테고리가 있는 경우 
		resultActions = 
				mockMvc
				.perform(delete("/api/admin/category/{no}",13L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(13)));
		
	}
	
	@Test
	public void dTestcategoryAllList() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/category").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print());
		
		
	}
	
}
