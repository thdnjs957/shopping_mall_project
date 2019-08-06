package com.cafe24.shop.frontend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.shop.frontend.config.app.AppSecurityConfig;
import com.cafe24.shop.frontend.config.app.OAuth2ClientConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.cafe24.shop.frontend.security", "com.cafe24.shop.frontend.service",  "com.cafe24.shop.frontend.repository", "com.cafe24.shop.frontend.aspect"})
//@Import({ AppSecurityConfig.class, OAuth2ClientConfig.class })
public class AppConfig {
}