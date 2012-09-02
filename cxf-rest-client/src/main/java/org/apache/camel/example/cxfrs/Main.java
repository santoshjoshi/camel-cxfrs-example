package org.apache.camel.example.cxfrs;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main{
	
	public static void main(String[] args) throws Exception {
		
		new ClassPathXmlApplicationContext("classpath:camel-Context.xml");
		Thread.currentThread().sleep(100000000l);
	}
}