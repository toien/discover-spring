package com.toien.discover.spring.container;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("service1")
public class Service1 implements BeanNameAware {

	public Service1() {
		System.out.println("### Service1 Constructing ###");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### Setting Name to Service1");

	}

}
