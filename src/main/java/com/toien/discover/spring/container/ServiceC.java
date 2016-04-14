package com.toien.discover.spring.container;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("serviceC")
public class ServiceC implements BeanNameAware {

	public ServiceC() {
		System.out.println("### ServiceC Constructing ###");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### Setting Name to ServiceC");
		
	}

}
