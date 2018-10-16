package com.st.springdemo;

import org.springframework.stereotype.Component;

// @Component("printer")
public class PrinterPrint implements Print {

	public void print(String msg) {
		  System.out.println("Printing to printer : " + msg);

	}

}
