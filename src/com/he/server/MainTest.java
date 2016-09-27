package com.he.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ct = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ApplicationContext wac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
