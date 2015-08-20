package com.toien.discover.spring.aop.service.impl;

import org.springframework.stereotype.Component;

import com.toien.discover.spring.aop.service.AccountService;


@Component("accountService")
public class AccountServiceImpl implements AccountService {

	@Override
	public void transfer(int money) {
		System.out.println("oh, $." + money + " is under transfering");
	}
}
