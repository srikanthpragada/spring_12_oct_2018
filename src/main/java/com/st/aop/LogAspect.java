package com.st.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component 
@Aspect
public class LogAspect {

	  @Before ("execution(* com.st.aop.AccountService.*(..))")
	  public void before() {
		  System.out.println("Before Advice");
	  }

	  @After("execution(* com.st.aop.AccountService.*(..))")
	  public void after() {
		  System.out.println("After Advice");
	  }
	  
	  
	  
}
