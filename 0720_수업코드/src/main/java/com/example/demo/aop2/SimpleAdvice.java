package com.example.demo.aop2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("------Before-------");
		System.out.println("getMethod() : " + invocation.getMethod().getName());
		
		Object ret = invocation.proceed();
		
		System.out.println("--------After:충고가 적용됨-------");
		return ret;
	}

}
