package com.st.springdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component 
@Primary 
public class ConsolePrint implements Print {
 
	 public ConsolePrint() {
		 System.out.println("ConsolePrint()");
	 }
	 
	 public void print(String msg) {
		 System.out.println(msg);
	 }
}
