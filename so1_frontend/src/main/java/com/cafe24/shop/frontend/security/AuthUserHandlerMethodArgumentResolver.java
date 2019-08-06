package com.cafe24.shop.frontend.security;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		Object principal = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication != null) {
			principal = authentication.getPrincipal();
		}
		
		if(principal == null || principal.getClass() == String.class) {
			return null;
		}
		
		return principal;//리턴하면 @AuthUser UserVo authUser에 세팅이 됨
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		
		AuthUser authUser = parameter.getParameterAnnotation(AuthUser.class);

		//@AuthUser가 안붙어있으면 
		if(authUser == null) {
			return false;
		}

		//파라미터 타입이 SecurityUser가 아님
		if(parameter.getParameterType().equals(SecurityUser.class) == false) {
			return false;
		}
		
		return true;
	}
	

}
