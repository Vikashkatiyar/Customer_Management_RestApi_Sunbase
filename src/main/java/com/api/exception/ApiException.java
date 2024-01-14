package com.api.exception;

public class ApiException extends RuntimeException {
	/**
	 * @author vikash katiyar
	 */
	private static final long serialVersionUID = 1L;

	public ApiException(String message) {
		super(message);

	}

	public ApiException() {
		super();

	}

}
