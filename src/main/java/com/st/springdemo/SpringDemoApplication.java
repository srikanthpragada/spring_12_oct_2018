package com.st.springdemo;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
  
@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

//	@Autowired
//	Hello hello;
	
	@Autowired
	@Qualifier("printer")
	Print printer;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
	public void run(String ... args) {
		// System.out.println(hello.getMessage());
		System.out.println(printer.getClass());
		printer.print("From Spring");
	}
}
 