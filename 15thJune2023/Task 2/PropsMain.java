package com.dal.props;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropsMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spr-props.xml");
		MyDao dao = (MyDao) context.getBean("dao");
		System.out.println(dao.getDbname() + "  " + dao.getUname() + "  " + dao.getPassword());
		
		
		ApplicationContext conContext = new ClassPathXmlApplicationContext("spr-mydbconn.xml");
		MyDbConnection dbconn = (MyDbConnection) conContext.getBean("mydbcon");
		System.out.println(dbconn.getMyConnection());  
	}

}
