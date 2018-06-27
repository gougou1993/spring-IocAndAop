package com.zhong.event;

import org.springframework.context.ApplicationEvent;
/**
 * 自定义事件
 * @author admin
 *
 */
public class CustomerEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1045236893100183836L;

	public CustomerEvent(Object source) {
		super(source);
	}

}
