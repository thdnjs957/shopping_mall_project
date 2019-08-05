package com.cafe24.shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cafe24.config.web.AuthorizationServerConfig;
import com.cafe24.config.web.FileuploadConfig;
//import com.cafe24.config.web.FileuploadConfig;
import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.ResourceServerConfig;
import com.cafe24.config.web.SecurityConfig;
import com.cafe24.config.web.SwaggerConfig;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.cafe24.shop.controller, com.cafe24.shop.cotroller.api, com.cafe24.shop.exception"})
@Import({MVCConfig.class, MessageConfig.class,SwaggerConfig.class,FileuploadConfig.class,SecurityConfig.class,ResourceServerConfig.class,AuthorizationServerConfig.class})//SecurityConfig.class,FileuploadConfig.class
public class WebConfig {
	
}