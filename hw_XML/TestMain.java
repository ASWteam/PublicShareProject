package com.example.hw_XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	
	public static void main(String[] args) {
//		Engine f1Engine = new F1Engine();
//		((F1Engine)f1Engine).setName("Best Engine");
//		
//		Car luxuryCar = new Car(f1Engine, "람보르기니");
//		
//		Driver proDriver = new Driver();
//		proDriver.setCar(luxuryCar);
//		proDriver.drive();
//		
//		System.out.println("---------------------");
//		
//		Engine hyundaiEngine = new HyundaiEngine();
//		((HyundaiEngine)hyundaiEngine).setName("Normal Engine");
//		
//		Car cheapCar = new Car(hyundaiEngine, "소나타");
//		
//		Driver driver = new Driver();
//		driver.setCar(cheapCar);
//		driver.drive();
//		
//		
		ApplicationContext context = new ClassPathXmlApplicationContext("hw-config.xml");
		
		Car car = context.getBean("car", Car.class);
		Driver driver = context.getBean("driver", Driver.class);
		driver.setCar(car);
		driver.drive();
		
		
		
		
		/**
		 * 과제: 위 코드에서 객체 생성 및 관계설정 부분을 다음 방식으로 변경한다.
		 * 1. XML
		 * 2. Annotation
		 * 패키지를 복사하여 개별적으로 작성해서 제출하세요 
		 */
		
	}

}
