package com.st.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Scope(scopeName="prototype")
public class Employee {
	private Print printer;
	
	@Autowired
	public void setPrinter(Print printer) {
		 System.out.println("Setting printer");
		 this.printer = printer;
	}
	// Constructor
	public Employee() {
		System.out.println("Constructor injection");
	}

	@PostConstruct
	public void onStartup() {
		System.out.println("onStartup()");
	}
	
	@PreDestroy  
	public void onDestory() {
		System.out.println("onDestory()");
	}

	public void print() {
		printer.print("Print Employee...");
	}
}
