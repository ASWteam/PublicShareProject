package com.example.demo.aop2;

public class First {
	@AdviceRequired //어드바이스가 적용될 것
	public void hello() {
		System.out.println("hello()");
	}
	
	public void sayHello() {
		System.out.println("sayHello()");
	}
}	
