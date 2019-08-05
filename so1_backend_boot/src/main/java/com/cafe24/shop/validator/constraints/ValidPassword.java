package com.cafe24.shop.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.shop.validator.PasswordValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=PasswordValidator.class)
public @interface ValidPassword {
	
	//default Message
	String message() default "Invalid Password";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
	
}