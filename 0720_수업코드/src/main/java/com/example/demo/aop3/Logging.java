package com.example.demo.aop3;

public class Logging {
	/**
	 * This is the method which I would like to execute before a selected method
	 * execution.
	 */
	public void beforeAdvice() {
		System.out.println("*****Going to setup student profile.*****");
	}
	
	public void afterAdvice() {
		System.out.println("#####Student profile has been setup.#####");
	}
	
	public void afterReturningAdvice(Object retVal) {
		System.out.println("@Returning >>>>> " + retVal.toString());
	}
	
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception >>>>>" + ex.toString());
	}
}
