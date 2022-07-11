package com.chainsys.springproject.beans;
//multiple factory methods in one class
//Calender factory is also called as initiating  bean because methods in this bean instantiates objects for other beans
public class CalenderFactory {
	//The factory method is not non static here
public Calender createCalender()
{
	//The Calender constructor is default acces modifier so, can be called here
	//The Calender class and Calender factory class are both in the same package
	return new Calender();
}
public Appointments createAppointments()
{
	return new Appointments();
}
}
