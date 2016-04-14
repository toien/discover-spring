package com.toien.discover.spring.container;

import javax.annotation.Resource;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("serviceB")
public class ServiceB implements BeanNameAware {

	private ServiceC serviceC;

	public ServiceB() {
		System.out.println("### ServiceB Constructing ###");
	}

	@Resource
	public void setServiceC(ServiceC serviceC) {
		System.out.println("$$$ Injecting ServiceC to ServiceB");
		this.serviceC = serviceC;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### Setting Name to ServiceB");

	}

}
