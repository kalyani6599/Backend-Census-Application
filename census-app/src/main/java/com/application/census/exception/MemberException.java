package com.application.census.exception;

public class MemberException extends Exception{

	public MemberException() {
		super();
	}

	public MemberException(String msg) {
		super(msg);
	}
	
	public MemberException(String msg, Throwable e) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
