package com.chainsys.springproject.getbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Car;

public class TestCar {
	public static void firstTest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Car2.xml");
		Car c = ac.getBean("jaguvar", Car.class);
	
	 c.start();
	 //c.move();
		 

	}
}
