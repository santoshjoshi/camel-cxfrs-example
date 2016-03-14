package org.apache.camel.example.cxfrs;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * Main Class Used for Executing the Application
 *
 */
public class Main{
	
	public static void main(String[] args) throws Exception {
		
		new ClassPathXmlApplicationContext("classpath:camel-context.xml");
		Thread.currentThread().sleep(1000000L);
	}
}