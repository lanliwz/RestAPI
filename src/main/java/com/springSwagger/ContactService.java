package com.springSwagger;

import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;





@Service
public class ContactService {

	
	@Autowired
	private MyDbConfig dbConfig;
	
	public Collection<Contact> select() {
		Contact c=new Contact();
		c.setEmail("abc@gmail.com");
		c.setName("Himanga");
		c.setUrl("http://11.1.1.1");
		
		Collection<Contact> collection=new ArrayList<Contact>();
		collection.add(c);
		return collection;
	}

	public Contact get(Long id) {
	
		/*Contact c=new Contact();
	
		c.setEmail("abc@gmail.com");
		c.setName("Himanga");
		c.setUrl("http://11.1.1.1");
		c.setId(1);
		
		if(id==c.getId()){
			return c;
		}
		return null;*/
		
		//return c;
		
		
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
	      //HelloWorld obj = (HelloWorld) applicationContext.getBean("helloWorld");
	    /*  MyDbConfig dbConfig = 
	      
	      //System.out.println(dbConfig.getUsername());
	      
	      Contact c=new Contact();
	  	
			c.setEmail("abc@gmail.com");
			c.setName(dbConfig.getUsername());
			c.setUrl(dbConfig.getUrl());
			c.setId(1);
			
			if(id==c.getId()){
				return c;
			}*/
	      /*MyDbConfig dbConfig = (MyDbConfig) context.getBean("dbConfig");
	              System.out.println(dbConfig.toString());
	              context.close();*/
	      
	     /* WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servlet.getServletContext());
	      SomeBean someBean = (SomeBean) ctx.getBean("someBean");*/
	      
	      return null;
	}

}
