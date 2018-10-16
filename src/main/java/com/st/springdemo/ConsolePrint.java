package com.st.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component 
public class ConsolePrint implements Print {
 
	 public ConsolePrint() {
		 System.out.println("ConsolePrint()");
	 }
	 
	 public void print(String msg) {
		 System.out.println(msg);
	 }
}
