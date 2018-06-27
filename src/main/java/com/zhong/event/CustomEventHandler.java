package com.zhong.event;

import org.springframework.context.ApplicationListener;
/**
 * 事件处理器
 * @author admin
 */
public class CustomEventHandler implements ApplicationListener<CustomerEvent>{

	@Override
	public void onApplicationEvent(CustomerEvent event) {
		System.out.println(event.toString());
	}

}
