package com.p1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.p1.demo.Car;


//  ioc

public class Main {
	
	public static void main(String[] args) {
		
		
//		Car car = new Car();
//		car.setEng(new PatrolEngine());
//		car.drive();
		
//		Car car = new Car(new PatrolEngine());
//		car.drive();
		
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
 Car c1= context.getBean(Car.class);
 c1.drive();
  
 
 
  

		
		
	}

}
