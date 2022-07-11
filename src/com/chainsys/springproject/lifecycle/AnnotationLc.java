package com.chainsys.springproject.lifecycle;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//not working from java9 and higher version
public class AnnotationLc {
public AnnotationLc()
{
	System.out.println("AnnotationLc object created" + hashCode());
}
@PostConstruct
public void start()
{
	System.out.println("start AnnotationLc");
}
@PreDestroy
public void stop()
{
	System.out.println("stopped AnnotationLc");
	}
public void print()
{
	System.out.println("print AnnotationLc called");
}
}
