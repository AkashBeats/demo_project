package com.example.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class businessException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorId;
	private String errorMessage;
	public businessException(int errorId, String errorMessage) {
		super();
		this.errorId = errorId;
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getErrorId() {
		return errorId;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	@Override
	public String toString() {
		return "businessException [errorId=" + errorId + ", errorMessage=" + errorMessage + "]";
	}
	public businessException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
