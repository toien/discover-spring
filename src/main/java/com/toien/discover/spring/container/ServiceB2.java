package com.toien.discover.spring.container;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("serviceB2")
public class ServiceB2 extends ServiceB implements BeanNameAware {

	public ServiceB2() {
		System.out.println("### ServiceB2 Constructing ###");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### Setting Name to ServiceB2");
	}
	
	@PostConstruct
	public void check() {
		System.out.println("!!! ServiceB2 calling PostConstruct method " + this.serviceC);
	}
}
