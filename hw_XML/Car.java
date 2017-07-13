package com.example.hw_XML;

public class Car {
	private Engine engine;
	private String name;

	public Car(){}
	
	public Car(Engine engine, String name) {
		this.engine = engine;
		this.name = name;
	}

	public boolean start() {
		if (engine.run()) {
			System.out.println("시동이 걸렸다.");
			return true;
		} else {
			System.out.println("시동이 걸리지 않았다. ");
			return false;
		}
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
