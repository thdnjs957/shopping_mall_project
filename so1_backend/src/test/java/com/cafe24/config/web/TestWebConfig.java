package com.cafe24.config.web;

import com.cafe24.config.web.SwaggerConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.MVCConfig;
//import com.cafe24.config.web.SecurityConfig;
//import com.cafe24.config.web.FileuploadConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shop.controller", "com.cafe24.shop.cotroller.api", "com.cafe24.shop.exception"})
@Import({TestMVCConfig.class, MessageConfig.class, SwaggerConfig.class})
public class TestWebConfig {
}