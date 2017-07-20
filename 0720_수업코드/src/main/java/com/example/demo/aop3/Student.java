package com.example.demo.aop3;

public class Student {

	private int age;
	private String name;

	public int getAge() {
		System.out.println("getAge() called.");
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		System.out.println("getName() called.");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printThrowException() {
		System.out.println("Exception raised");
		throw new IllegalArgumentException();
	}

}
