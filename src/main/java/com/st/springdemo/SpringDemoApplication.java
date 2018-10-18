package com.st.springdemo;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
  
@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    @Autowired
    private Employee emp;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
	
	public void run(String ... args) {
		emp.print(); 
	}
}
 