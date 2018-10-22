package com.st.aop;

import org.springframework.stereotype.Component;

@Component 
public class AccountService {
	
	public void deposit(double amount) {
		System.out.println("Depositing " + amount);
	}
	
	public void withdraw(double amount) {
		System.out.println("Withdrawing "  + amount);
	}

}
