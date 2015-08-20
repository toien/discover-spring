package com.toien.discover.spring.aop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toien.discover.spring.aop.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class SomeTest implements ApplicationContextAware {
	
	private ApplicationContext context;

	@Test
	public void testWhat() {
		
		AccountService accountService = (AccountService) context.getBean("accountService");
		accountService.transfer(100);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
