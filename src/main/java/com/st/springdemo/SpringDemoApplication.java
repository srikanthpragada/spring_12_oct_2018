package com.st.springdemo;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
  
@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

//    @Autowired
//    private Employee emp1, emp2;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
	public void run(String ... args) {
		// System.out.println(hello.getMessage());
//		System.out.println(emp1); 
//		System.out.println(emp2);
	}
}
 