package com.chainsys.springproject.test;
import org.springframework.context.ApplicationContext;//parent
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;//child

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calender;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.Scoreboard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;
public class TestClasspathXml {
	public static void testA() {
		Employee emp=new Employee();
		emp.setId(100);
		emp.setName("Warner");
		emp.print();
		}
		public static void testB() {
			ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=(Employee)ac.getBean("emp");
		emp.setId(100);
		emp.setName("maxwell");
		emp.print();
		Customer c=ac.getBean(Customer.class);
		c.setId(23);
		c.setName("kholi");
		c.print();
		}
		public static void testLazyinit()
		{
			ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
			Employee emp=ac.getBean (Employee.class);
			Customer c = ac.getBean(Customer.class);
			//lazy-init="true" for Customer.An object is created now(firstcall to getbean() method for Customer.class)
			Employee secondemp=ac.getBean (Employee.class);
			Customer secondcus =ac.getBean(Customer.class);
			System.out.println(emp.hashCode());
			System.out.println(secondemp.hashCode());
			System.out.println(c.hashCode());
			System.out.println(secondcus.hashCode());
		}
		public static void testPrototype()
		{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
			Actor hero=ac.getBean(Actor.class);
			Actor heroine=ac.getBean(Actor.class);
			Actor comedian=ac.getBean(Actor.class);
			Actor friend=ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
			System.out.println(heroine.hashCode());
			System.out.println(comedian.hashCode());
			System.out.println(friend.hashCode());
		}
		public static void testBeanwithConstructor()
		{
			ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		}
		public static void testFactoryMethod() {
			ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
			Scoreboard sb=ac.getBean("sb1",Scoreboard.class);
			sb.targetScore=183;
			System.out.println(sb.targetScore);
			Scoreboard sb2=ac.getBean("sb2",Scoreboard.class);
			System.out.println(sb2.targetScore);
		}
		public static void testCalenderFactory() { 
			ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calender today=ac.getBean(Calender.class);
		today.day=9;
		today.month="june";
		today.year=2022;
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
		}	
		public static void testLunchFactory() { 
			ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml"); 
			Lunch nvsilunch=ac.getBean("nvsilunch", Lunch.class); 
			Lunch vsilunch=ac.getBean("vsilunch", Lunch.class);
			Lunch nilunch=ac.getBean("nilunch", Lunch.class);
			Lunch chlunch=ac.getBean("chlunch", Lunch.class); 
			System.out.println("-----");
			nvsilunch.serve();
			System.out.println("-- -"); 
			vsilunch.serve();
			System.out.println("-----");
			nilunch.serve();
			System.out.println("-----");
			chlunch.serve();
		}
		public static void testSetterDi()
		{ ApplicationContext acl=new ClassPathXmlApplicationContext("beans.xml");
		Employee emp=acl.getBean("emp2", Employee.class); 
		emp.print(); 
		}
		public static void testLifeCycle() { 
			ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml"); 
			LifeCycleBean life= ac1.getBean(LifeCycleBean.class); 
			life.print();
			/*
			 * LifeCycleBean life1= ac1.getBean(LifeCycleBean.class); LifeCycleBean life2=
			 * ac1.getBean(LifeCycleBean.class);
			 */
			life=null;
			//System.gc();
			ac1.close();
			ac1=null;
			
			
		}
		public static void testInitDestroyBean() { 
			ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
			InitDesposeBean init= ac1.getBean(InitDesposeBean.class);
			init.print();
		}
		public static void testAnnotationLc() { 
			ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
			AnnotationLc ann= ac1.getBean(AnnotationLc.class);
			ann.print();
			ann=null;
			ac1.close();
		}
		public static void testAutowire() { 
			ConfigurableApplicationContext acl = new ClassPathXmlApplicationContext("Autowire.xml"); 
			Car car= acl.getBean("car",Car.class); 
			car.move();
			car=null;
			acl.close();
		}
		public static void testAutowireQualifier() { 
			 ConfigurableApplicationContext acl = new ClassPathXmlApplicationContext("Autowire.xml"); 
			 CarServices cs =acl.getBean(CarServices.class);
			 cs.startTrip();
		}
}
