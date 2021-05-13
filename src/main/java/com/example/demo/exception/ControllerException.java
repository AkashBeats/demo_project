package com.example.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ControllerException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	private String errorMessage;
	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

