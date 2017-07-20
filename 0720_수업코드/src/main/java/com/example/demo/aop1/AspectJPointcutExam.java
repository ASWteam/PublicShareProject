package com.example.demo.aop1;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectJPointcutExam {

	public static void main(String[] args) {
		First target = new First();
		
		//Advisor
		AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
		//파라미터, 리턴에 관계없이 hello로 시작되는
		pc.setExpression("execution(* hello*(..))");
		Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
		
		//Proxy
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(target);
		pf.addAdvisor(advisor);
		First proxy = (First) pf.getProxy();
		
		proxy.hello();
		proxy.hello2();
		proxy.sayHello();
	}
}
