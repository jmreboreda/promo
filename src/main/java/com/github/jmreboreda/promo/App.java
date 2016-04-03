package com.github.jmreboreda.promo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.jmreboreda.promo.services.ClientsManager;

public class App
{
    public static void main( String[] args )
    {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

     	@SuppressWarnings("unused")
		ClientsManager clientsManager = (ClientsManager) context.getBean("clientsManager");
     	
        System.out.println( "Hello World!" );
    }
}
