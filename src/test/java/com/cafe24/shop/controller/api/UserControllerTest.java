package com.cafe24.shop.controller.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.config.web.TestWebConfig;
import com.cafe24.shop.config.AppConfig;
import com.cafe24.shop.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class, TestWebConfig.class})
@WebAppConfiguration
public class UserControllerTest {
	
//	@Test
//	public void testDIUserService() {
//		assertNotNull(userService);
//	}
//	
//	@Autowired
//	private Calcurator cal;
//	
//	
//	@Test                                                                            
//    public void testSum(){                
//        double result = cal.sum(10, 50);                                  
//        assertEquals(60, result, 0);                                          
//    }
	
	@Autowired
	private UserService userService; 
	
	@Test
	public void testDIUserService() {
		assertNotNull(userService);
	}
	
}