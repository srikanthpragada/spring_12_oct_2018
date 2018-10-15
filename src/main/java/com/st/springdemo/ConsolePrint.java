package com.st.springdemo;

import org.springframework.stereotype.Component;

@Component 
public class ConsolePrint implements Print {
 
	 public void print(String msg) {
		 System.out.println(msg);
	 }
}
