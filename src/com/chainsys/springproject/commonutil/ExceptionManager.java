package com.chainsys.springproject.commonutil;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExceptionManager {
   public static String handleException(Exception e,String source,String message) {
       ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Employee.xml");
       context.getBean(LogManager.class).logException(e,source,message);
    //   LogManager.logException(e,source);
     message += message;
     //  String errorPage=HtmlHelper.getHtmlTemplate("Error", message);
        return null;
   }
}
