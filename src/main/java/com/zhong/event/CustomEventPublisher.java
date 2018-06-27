package com.zhong.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
/**
 * 事件发布
 * @author admin
 *
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void publish() {
		CustomerEvent ce = new CustomerEvent(this);
		applicationEventPublisher.publishEvent(ce);
	}
}
