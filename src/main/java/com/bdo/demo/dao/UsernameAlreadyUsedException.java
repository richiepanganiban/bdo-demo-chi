package com.bdo.demo.dao;

public class UsernameAlreadyUsedException extends Exception {
	private static final long serialVersionUID = -6124767507107011017L;

	public UsernameAlreadyUsedException(String message) {
		super(message);
	}

	public UsernameAlreadyUsedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
