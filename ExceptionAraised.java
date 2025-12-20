package com.exception;

public class ExceptionAraised extends RuntimeException{
	String st;

	public ExceptionAraised(String st) {
		this.st = st;
	}
	

}
