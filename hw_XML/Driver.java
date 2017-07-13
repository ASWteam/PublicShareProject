package com.example.hw_XML;

public class Driver {
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	public void drive() {
		if (car.start()) {
			System.out.println(car.getName() + "를 운전한다.");
		}
	}
}
