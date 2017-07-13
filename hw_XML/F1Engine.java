package com.example.hw_XML;

public class F1Engine implements Engine {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean run() {
		System.out.println("F1 포뮬러 엔진 " + name + "이 움직인다.");
		return true;
	}

	@Override
	public boolean stop() {
		System.out.println("F1 포뮬러 엔진 " + name + "이 멈춘다.");
		return true;
	}

}
