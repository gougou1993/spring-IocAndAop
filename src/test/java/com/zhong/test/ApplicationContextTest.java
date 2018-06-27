package com.zhong.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhong.dao.UserDao;
import com.zhong.entity.User;

public class ApplicationContextTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("spring/application-config.xml");
		
		UserDao userDao = applicationContext.getBean(UserDao.class);
		User user = userDao.findById(1L);
		System.out.println(user);
		
	}
}
