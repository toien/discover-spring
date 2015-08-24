package com.toien.discover.spring.aop.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.toien.discover.spring.anno.SysLog;

public class AccountListener {
	public void listen(JoinPoint joinPoint) {

		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();

		Object target = joinPoint.getTarget();
		Method callee = getCallee(target, methodSign);
		Object[] args = joinPoint.getArgs();

		SysLog log = callee.getAnnotation(SysLog.class);
		if (log != null) {

			scanLoggedParameter(callee, args);

		}

	}

	private void scanLoggedParameter(Method callee, Object[] arguments) {
		if (arguments.length <= 0) {
			return;
		}

		Annotation[][] annos = callee.getParameterAnnotations();

		for (int paramIndex = 0; paramIndex < annos.length; paramIndex++) {

			Annotation[] paramAnno = annos[paramIndex];

			if (paramAnno.length > 0) {
				for (Annotation anno : paramAnno) {
					if (anno instanceof SysLog) {

						SysLog log = (SysLog) anno;

						toLogBusiness(log, arguments[paramIndex]);

					}
				}
			}
		}

	}

	private void toLogBusiness(SysLog log, Object param) {
		System.out.format("Listening ENTITY is: %s, ACTION is: %s and Number is %d \n",
				log.entity(), log.action(), param);
	}

	private Method getCallee(Object target, MethodSignature signature) {
		Method callee = null;
		try {
			callee = target.getClass()
					.getMethod(signature.getName(), signature.getParameterTypes());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return callee;
	}
}
