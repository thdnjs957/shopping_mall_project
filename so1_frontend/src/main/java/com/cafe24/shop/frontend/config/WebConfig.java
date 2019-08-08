package com.cafe24.shop.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.shop.frontend.config.web.FileuploadConfig;
import com.cafe24.shop.frontend.config.web.MVCConfig;
import com.cafe24.shop.frontend.config.web.MessageConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shop.frontend.controller", "com.cafe24.shop.frontend.exception"})
@Import({ MVCConfig.class,MessageConfig.class,FileuploadConfig.class })
public class WebConfig {
}
