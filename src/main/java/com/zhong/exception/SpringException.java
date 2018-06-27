package com.zhong.exception;

public class SpringException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2640529809711659770L;
	private String exceptionMsg;

	public SpringException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

}
