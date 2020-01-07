package com.ragnax.ssoorquestador.exception;

import java.io.Serializable;

public class SSOOrquestadorException extends Exception implements Serializable{

	private static final long serialVersionUID = 9091284050715615670L;

	public SSOOrquestadorException(){
		super();
	}

	public SSOOrquestadorException(String message){
		super(message);
	}
	
	public SSOOrquestadorException(String message, Throwable cause){
		super(message, cause);
	}
	
	
	public SSOOrquestadorException(Throwable cause){
		super(cause);
	}
}
