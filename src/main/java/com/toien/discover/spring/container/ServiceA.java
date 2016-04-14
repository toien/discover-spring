package com.toien.discover.spring.container;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("serviceA")
public class ServiceA implements BeanNameAware  {

	private ServiceB serviceB;

	public ServiceA() {
		System.out.println("### ServiceA Constructing ###");
	}

	@Resource
	public void setServiceB(ServiceB serviceB) {
		System.out.println("$$$ Injecting ServiceB to ServiceA");
		this.serviceB = serviceB;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### Setting Name to ServiceA");
		
	}

}
