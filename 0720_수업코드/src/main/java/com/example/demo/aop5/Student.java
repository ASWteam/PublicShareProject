package com.example.demo.aop5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	private int age;
	private String name;

	public int getAge() {
		System.out.println("getAge() called.");
		return age;
	}

	@Value("19")
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		System.out.println("getName() called.");
		return name;
	}

	@Value("KKK")
	public void setName(String name) {
		this.name = name;
	}
	
	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}

}
