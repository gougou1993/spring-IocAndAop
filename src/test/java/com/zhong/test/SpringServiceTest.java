package com.zhong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhong.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-config.xml"})
public class SpringServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void findByIdTest(){
		this.userService.findById(1L);
	}
}
