package com.zhong.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value=Suite.class)
@SuiteClasses({SpringDaoTest.class,SpringServiceTest.class})
public class AllTests {
	
}
