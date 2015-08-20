package com.toien.discover.spring.aop.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.toien.discover.spring.anno.SysLog;

public class AccountListener {
	public void listen(JoinPoint joinPoint) {

		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();

		Method interfaceMethod = findParentMethod(methodSign);

		SysLog log = interfaceMethod.getAnnotation(SysLog.class);

		System.out.format("Listening ENTITY is: %s, ACTION is: %s", log.entity(), log.action());

	}

	private Method findParentMethod(MethodSignature methodSignature) {

		Class<?> declaringType = methodSignature.getDeclaringType();

		Method declaringMethod = null;
		try {
			declaringMethod = declaringType.getMethod(methodSignature.getName(),
					methodSignature.getParameterTypes());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return declaringMethod;
	}
}
