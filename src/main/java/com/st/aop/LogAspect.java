package com.st.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	// @Before ("execution(* com.st.aop.AccountService.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("Before method : " + jp.getSignature());
	}

	// @After("execution(* com.st.aop.AccountService.*(..))")
	public void after() {
		System.out.println("After Finally");
	}

	// @AfterReturning("execution(* com.st.aop.AccountService.*(..))")
	public void afterSuccess() {
		System.out.println("After Success!");
	}

	// @AfterThrowing(pointcut="execution(* com.st.aop.AccountService.*(..))",
	// throwing="ex")
	public void afterError(Exception ex) {
		System.out.println("After Error : " + ex);
	}

	@Around("execution(* com.st.aop.AccountService.deposit(..))")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("Calling Deposit Method");
		try {
			pjp.proceed(pjp.getArgs());  // call actual method 
			System.out.println("Done depositing");
		} catch (Throwable e) {
			System.out.println("Error during depositing");
		}
	}
}
