package com.p1.demo;

public class PatrolEngine implements IEngine{
	
 public PatrolEngine() {
		System.out.println("patrol eng Const");
	}

	public int start() {
		System.out.println("patroal Engine Start");
		return 1;
	}
}
