package com.cafe24.shop.controller.api.admin;

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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.cafe24.shop.vo.ImageVo;
import com.cafe24.shop.vo.OptionMasterVo;
import com.cafe24.shop.vo.OptionVo;
import com.cafe24.shop.vo.ProductOptionVo;
import com.cafe24.shop.vo.ProductVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
//@TransactionConfiguration(defaultRollback = true)
//@Transactional
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

		ProductVo vo = new ProductVo(null,"바즤","바지입니다.",15000,true,"<div>바지 상품 설명입니다.</div>",100,"2019-07-16",4L);
		
		List<ImageVo> proImageList = new ArrayList<ImageVo>();
		
		ImageVo image1 = new ImageVo(null,"com/cafe24/images/image11.png",true,null);
		ImageVo image2 = new ImageVo(null,"com/cafe24/images/image12.png",false,null);
		ImageVo image3 = new ImageVo(null,"com/cafe24/images/image13.png",false,null);
		
		proImageList.add(image1);
		proImageList.add(image2);
		proImageList.add(image3);
		
		vo.setPro_Image(proImageList);
		
		///option 리스트 생성
		List<OptionVo> optionList = new ArrayList<OptionVo>();
		
		List<OptionMasterVo> optionMaList1 = new ArrayList<OptionMasterVo>();
		
		OptionMasterVo optionMa1 = new OptionMasterVo(null,"진청",null);
		
		optionMaList1.add(optionMa1);
		//optionMaList1.add(optionMa2);
		
		List<OptionMasterVo> optionMaList2 = new ArrayList<OptionMasterVo>();
		
		OptionMasterVo optionMa3 = new OptionMasterVo(null,"S",null);
		OptionMasterVo optionMa4 = new OptionMasterVo(null,"M",null);
		OptionMasterVo optionMa5 = new OptionMasterVo(null,"L",null);
		
		optionMaList2.add(optionMa3);
		optionMaList2.add(optionMa4);
		optionMaList2.add(optionMa5);
		
		OptionVo option1 = new OptionVo(null,"색상",null,optionMaList1);
		OptionVo option2 = new OptionVo(null,"사이즈",null,optionMaList2);
		
		optionList.add(option1);
		optionList.add(option2);
		
		vo.setOption(optionList);
		
		//미리 위에 리스트에 따라서 동적으로 담아줌 
		List<ProductOptionVo> proOptionList = new ArrayList<ProductOptionVo>();
		
		ProductOptionVo proOption1 = new ProductOptionVo(null, "진청/S",100,true,0,null);
		ProductOptionVo proOption2 = new ProductOptionVo(null, "진청/M",200,false,1000,null);
		ProductOptionVo proOption3 = new ProductOptionVo(null, "진청/L",200,false,1000,null);
		
		proOptionList.add(proOption1);
		proOptionList.add(proOption2);
		proOptionList.add(proOption3);
		
		vo.setPro_option(proOptionList);
		
		ResultActions resultActions = 
			mockMvc
			.perform(post("/api/admin/product/register").contentType(MediaType.APPLICATION_JSON)
			 .content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
			.andDo(print())
			.andExpect(jsonPath("$.data", is(true)));
		
		
	}
	
	
	@Test
	public void productUpdate() throws Exception{
																	  //디테일만 null
		ProductVo vo = new ProductVo(null,"원피스","원피스입니다.",20000,true,null,100,"2019-07-16",null);
		
		
		List<ImageVo> proImageList = new ArrayList<ImageVo>();
		
		ImageVo image1 = new ImageVo(null,"com/cafe24/images/image4.png",true,null);
		ImageVo image2 = new ImageVo(null,"com/cafe24/images/image5.png",false,null);
		ImageVo image3 = new ImageVo(null,"com/cafe24/images/image6.png",false,null);
		
		proImageList.add(image1);
		proImageList.add(image2);
		proImageList.add(image3);
		
		vo.setPro_Image(proImageList);
		
		///option 리스트 생성
		List<OptionVo> optionList = new ArrayList<OptionVo>();
		
		List<OptionMasterVo> optionMaList1 = new ArrayList<OptionMasterVo>();
		
		OptionMasterVo optionMa1 = new OptionMasterVo(null,"퍼플",null);
		OptionMasterVo optionMa2 = new OptionMasterVo(null,"옐로우",null);
		
		optionMaList1.add(optionMa1);
		optionMaList1.add(optionMa2);
		
		List<OptionMasterVo> optionMaList2 = new ArrayList<OptionMasterVo>();
		
		OptionMasterVo optionMa3 = new OptionMasterVo(null,"S",null);
		
		optionMaList2.add(optionMa3);
		
		OptionVo option1 = new OptionVo(null,"색상",null,optionMaList1);
		OptionVo option2 = new OptionVo(null,"사이즈",null,optionMaList2);
		
		optionList.add(option1);
		optionList.add(option2);
		
		vo.setOption(optionList);
		
		List<ProductOptionVo> proOptionList = new ArrayList<ProductOptionVo>();
		
		ProductOptionVo proOption1 = new ProductOptionVo(null, "퍼플/S",100,true,0,null);
		ProductOptionVo proOption2 = new ProductOptionVo(null, "옐로우/S",200,false,1000,null);
		
		proOptionList.add(proOption1);
		proOptionList.add(proOption2);
		
		vo.setPro_option(proOptionList);
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/{no}",10L).contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
		
	}
	
	@Ignore
	@Test
	public void productDelete() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/{no}",8L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		.andExpect(jsonPath("$.data.no", is(8)))
		;
	}
	
	@Ignore
	@Test
	public void productListforAdmin() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	
	@Test
	public void productListforUser() throws Exception{

		//카테고리 no 있을때 
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/{no}",13L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
		
		//카테고리 선택 x 메인 페이지 상품 리스트 다 보여주기
		resultActions = 
				mockMvc
				.perform(get("/api/product").contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	@Test
	public void productDetailforUser() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/product/{no1}/{no2}",13L,10L).contentType(MediaType.APPLICATION_JSON));
		
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;

	}
	
	@Ignore
	@Test
	public void productGetByNo() throws Exception{

		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/{no}",4L).contentType(MediaType.APPLICATION_JSON));
		resultActions.andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$.result", is("success")))
		;
	}
	
	@Ignore
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
	
	
}
