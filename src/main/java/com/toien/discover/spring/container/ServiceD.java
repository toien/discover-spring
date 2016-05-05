package com.toien.discover.spring.container;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

@Service("serviceD")
public class ServiceD implements BeanNameAware {

	public ServiceD() {
		System.out.println("### ServiceD Constructing ###");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### Setting Name to ServiceD");

	}

}
