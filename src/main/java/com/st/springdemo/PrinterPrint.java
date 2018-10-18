package com.st.springdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
// @Primary
public class PrinterPrint implements Print {

	public void print(String msg) {
		  System.out.println("Printing to printer : " + msg);

	}

}
