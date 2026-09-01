package com.p1.demo;

public class Car {
	
	private IEngine eng;
	
	
	public Car(IEngine eng) {
		this.eng = eng;
		System.out.println("Car param Const");
	}
	

	public Car() {
		System.out.println("Car Default Const");
		
	}


	public void setEng(IEngine eng) {
		this.eng = eng;
	}
	
	
	public void drive() {
		int status = eng.start();
		
		if (status >= 1) {
			System.out.println("Journey Started..");
		} else {
			System.out.println("Engine Trouble..");
		}
	}
	
	
	
	





	

}
