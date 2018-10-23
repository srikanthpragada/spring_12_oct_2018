package com.st.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  
public class AOPTest implements CommandLineRunner {
	@Autowired
	AccountService accountService;
	

	public static void main(String[] args) {
		SpringApplication.run(AOPTest.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		  System.out.println(accountService.getClass());
	      accountService.deposit(10000);
	      //accountService.withdraw(10000);
	      //accountService.withdraw(-10000);
	}
	
}
