package com.chainsys.springproject.autowire;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;//@Resources are not working
public  class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired
	private Wheel alloy;
	
	public Car() {
		System.out.println(" Car Object created "+ hashCode());
	}
	
	public void start() {
		petrolEngine.start();
	}
	public void move() {
		alloy.rotate();
	}
	
	public void begin()
	{
		System.out.println("start AnnotationLc");
	}
	
	public void stop()
	{
		System.out.println("stopped AnnotationLc");
		}
}
	@Component("SportsCar")
	class SportsCar extends Car{
		public SportsCar()
		{
			System.out.println("Sports car  object created" +hashCode());
		}
	}
	@Component("SuvCar")
	class SuvCar extends Car{
		public SuvCar()
		{
			System.out.println("Suv car object created" + hashCode());
		}
	}