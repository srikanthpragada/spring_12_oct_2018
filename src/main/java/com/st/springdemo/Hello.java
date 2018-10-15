package com.st.springdemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy  // lazy instantiation 
public class Hello {
    
	public Hello() {
		System.out.println("Object of Hello being created!");
	}
	public String getMessage() {
		return "Hello Spring";
	}
	
}
