package com.example.demo.aop2;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class AnnotationPointcutExam {
	public static void main(String[] args) {
		First target = new First();
		
		AnnotationMatchingPointcut pc =
				AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);
		
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		//Proxy
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		
		First proxy = (First)pf.getProxy();
		
		proxy.hello();
		proxy.sayHello();

	}
}
