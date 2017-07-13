package com.example.hw_XML;

import java.util.Random;

public class HyundaiEngine implements Engine {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private Random rnd = new Random();

	@Override
	public boolean run() {
		if (rnd.nextInt(4) > 1) {
			System.out.println("현대 엔진 " + name + "이 움직인다.");
			return true;
		} else {
			System.out.println("현대 엔진 " + name + "이 움직이지 않는다.");
			return false;
		}
	}

	@Override
	public boolean stop() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("현대 엔진 " + name + "이 드디어 2초 후에 멈췄다.");
		return true;
	}

}
