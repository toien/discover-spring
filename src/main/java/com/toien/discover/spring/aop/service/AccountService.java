package com.toien.discover.spring.aop.service;

import com.toien.discover.spring.anno.SysLog;

public interface AccountService {
	
	@SysLog(entity="Account", action="transfer")
	void transfer(int money);

}
