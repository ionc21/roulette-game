package com.caci.roulette.exception;

public class RouletteGameException extends Exception {
	private static final long serialVersionUID = -6622841408803762621L;

	private String message;

	public RouletteGameException(final String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
