package com.example.demo.aop1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("---Before-----------------");
		
		System.out.println(invocation.getMethod().getName());
		
		Object ret = invocation.proceed();
		
		System.out.println("---After: 충고적용---");
		return ret;
	}

}
