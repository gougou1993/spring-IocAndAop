package com.zhong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhong.dao.UserDao;
import com.zhong.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)			//使用junit4进行测试
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})//加载配置文件
public class SpringDaoTest implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	// 获得 applicationContext
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext =applicationContext;
	}
	
	@Test
	public void userDaoTest(){
		UserDao userDao = applicationContext.getBean(UserDao.class);
		UserDao userDao2 = applicationContext.getBean(UserDao.class);
		if(userDao == userDao2){//
			System.out.println(true);
		}
		User user = userDao.findById(1L);
	}
}
