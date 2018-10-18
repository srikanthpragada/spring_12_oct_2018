package com.st.info;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;

@SpringBootApplication  
public class ListBeans implements CommandLineRunner {

	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	DataSourceProperties prop;

	public static void main(String[] args) {
		SpringApplication.run(ListBeans.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	     listDataSourceProperties();
	}
	
	public void listDataSourceProperties() {
		System.out.println(prop.getUsername());
		System.out.println(prop.getUrl());
	}

	public void listBeans() {
		String names[] = ctx.getBeanDefinitionNames();
		Arrays.sort(names);
		for (String name : names)
			 System.out.println(name);
			
	}
}
